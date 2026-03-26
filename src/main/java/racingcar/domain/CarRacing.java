package racingcar.domain;


import java.util.Collections;
import java.util.List;

public class CarRacing {
    public record GameResult(List<Car> winners) {
    }


    public final List<Car> cars;
    public final int gameCount;

    public CarRacing(List<Car.Name> carNames, int gameCount) {
        this.cars = carNames.stream().map(this::createCar).toList();

        this.gameCount = gameCount;
    }

    protected Car createCar(Car.Name name) {
        ObstaclesAhead obstacles = new ObstaclesAhead.ByRandom();
        Environment environment = new Environment(obstacles);

        return new Car(environment, name);
    }


    public GameResult playGame() {
        for (int i = 0; i < gameCount; i++) {
            progressOnce();
        }

        return getResult();
    }

    /**
     * 게임을 1회 실행
     */
    public void progressOnce() {
        for (Car car : cars) {
            car.tryAdvance();
        }
    }

    public GameResult getResult() {
        List<Car> winners = getWinners();
        return new GameResult(winners);
    }

    private List<Car> getWinners() {
        if (cars.isEmpty()) {
            return Collections.emptyList();
        }

        int max = cars.stream()
                .mapToInt(Movable::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

}
