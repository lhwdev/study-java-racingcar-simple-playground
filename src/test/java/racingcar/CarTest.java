package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    void 이름을_갖는다() {
        Environment environment = new Environment(new ObstaclesAhead.ByRandom(0));
        Car car = new Car(environment, "Lamborghini");

        assertThat(car.name).isEqualTo("Lamborghini");
    }

    @Test
    void 앞으로_움직일_수_있다() {
        Environment environment = new Environment(new ObstaclesAhead.ByRandom(0));
        Car car = new Car(environment, "Lamborghini");

        for (int i = 0; i < 5; i++) {
            car.tryMove();
        }

        assertThat(car.getPosition()).isGreaterThan(0);
    }

    @Test
    void 장애물을_피하면_한칸_이동한다() {
        Environment environment = new Environment(new TestObstacles());
        Car car = new Car(environment, "Ferrari");

        for (int i = 0; i < TestObstacles.RESULTS.length; i++) {
            car.tryMove();
        }

        assertThat(car.getPosition()).isEqualTo(TestObstacles.AVOIDED_RESULT_COUNT);
    }
}
