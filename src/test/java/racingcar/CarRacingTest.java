package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


@SuppressWarnings("NonAsciiCharacters")
public class CarRacingTest {

    @Test
    void 시나리오_테스트() {
        int carCount = 5;
        int gameCount = 8;
        CarRacing racing = new TestRacing(carCount, gameCount);

        assertThat(racing.cars).hasSize(carCount);
        assertThat(racing.gameCount).isEqualTo(gameCount);

        for (int i = 0; i < carCount; i++) {
            Car car = racing.cars.get(i);

            assertThat(car).isNotNull();
            assertThat(car.getPosition()).isEqualTo(0);
            assertThat(car.name).isEqualTo("Car " + (i + 1));
        }

        CarRacing.GameResult result = racing.playGame();

        assertThat(result.winners())
                .hasSizeGreaterThan(0)
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isGreaterThan(0);
                });

        assertThat(racing.cars).anySatisfy(car -> {
            assertThat(car.getPosition()).isGreaterThan(0);
        });
    }


    @Test
    void 최대_게임_횟수만큼_전진한다() {
        int gameCount = 10;

        CarRacing racing = new CarRacing(3, gameCount) {
            @Override
            protected Car createCar(int carIndex) {
                return new Car(Environment.PASS, "Car " + (carIndex + 1));
            }
        };

        CarRacing.GameResult result = racing.playGame();
        assertThat(result.winners())
                .hasSize(racing.cars.size())
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isEqualTo(gameCount);
                });
    }

    @Test
    void 전진하지_않을_수도_있다() {
        int gameCount = 10;

        CarRacing racing = new CarRacing(3, gameCount) {
            @Override
            protected Car createCar(int carIndex) {
                return new Car(Environment.STOP, "Car " + (carIndex + 1));
            }
        };

        CarRacing.GameResult result = racing.playGame();
        assertThat(result.winners())
                .hasSize(racing.cars.size())
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isEqualTo(0);
                });
    }


    static class TestRacing extends CarRacing {

        public TestRacing(int carCount, int gameCount) {
            super(carCount, gameCount);
        }

        @Override
        protected Car createCar(int carIndex) {
            ObstaclesAhead obstacles = new ObstaclesAhead.ByRandom(carIndex);
            Environment environment = new Environment(obstacles);

            return new Car(environment, "Car " + (carIndex + 1));
        }

    }

}
