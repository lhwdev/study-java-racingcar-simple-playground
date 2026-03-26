package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.domain.TestCarRacing;


@SuppressWarnings("NonAsciiCharacters")
public class ApplicationViewTest {

    @Test
    void 일반적인_시나리오에서_잘_작동한다() {
        List<String> carStringNames = List.of("neo", "brie", "brown");
        List<Car.Name> carNames = carStringNames.stream()
                .map(Car.Name::new)
                .toList();
        int gameCount = 5;

        TestViewInput input = new TestViewInput(carNames, gameCount);
        ApplicationView application = ApplicationView.playGame(input);

        List<ProgressionView> progressions = application.progressions();
        assertThat(progressions)
                .hasSize(gameCount)
                .allSatisfy(progression -> {
                    var assertCars = assertThat(progression.cars);

                    assertCars.hasSize(carNames.size());

                    assertCars.map(car -> car.name)
                            .isEqualTo(carStringNames);

                    assertCars.allSatisfy(car -> {
                        assertThat(car.position).isGreaterThanOrEqualTo(0);
                    });
                });

        GameResultView result = application.result();
        Map<String, Car> carsByName = input.getCarsByName();
        assertThat(result.getWinnerNames())
                .hasSizeGreaterThan(0)
                .allSatisfy(winner -> {
                    assertThat(carsByName.get(winner).getPosition())
                            .isGreaterThan(0);
                });
    }


    static class TestViewInput extends ViewInput {

        CarRacing createdRacing;

        public TestViewInput(List<Car.Name> carNames, int gameCount) {
            super(carNames, gameCount);
        }


        @Override
        public CarRacing createGame() {
            CarRacing racing = new TestCarRacing(carNames, gameCount);
            createdRacing = racing;
            return racing;
        }

        public Map<String, Car> getCarsByName() {
            return createdRacing.cars.stream()
                    .collect(Collectors.toMap(Car::getName, car -> car));
        }

    }

}
