package racingcar;


import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {
    public record GameResult(List<Car> winners) {
    }


    final List<Car> cars;
    final int gameCount;

    public CarRacing(int carCount, int gameCount) {
        this.cars = IntStream.range(0, carCount)
                .mapToObj(this::createCar)
                .toList();

        this.gameCount = gameCount;
    }

    protected Car createCar(int carIndex) {
        ObstaclesAhead obstacles = new ObstaclesAhead.ByRandom();
        Environment environment = new Environment(obstacles);

        return new Car(environment, "Car " + (carIndex + 1));
    }


    public GameResult playGame() {
        for (int i = 0; i < gameCount; i++) {
            progressOnce();
        }

        List<Car> winners = getWinners();
        return new GameResult(winners);
    }

    /**
     * 게임을 1회 실행
     */
    private void progressOnce() {
        for (Car car : cars) {
            car.tryAdvance();
        }
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
