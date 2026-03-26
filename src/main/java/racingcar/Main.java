package racingcar;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        MainInput input = MainInput.promptAndRead();

        Main main = new Main(input);
        CarRacing.GameResult result = main.playGame();
        printGameResult(result);
    }

    private static void printGameResult(CarRacing.GameResult result) {
        List<Car> winners = result.winners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.print(winnerNames);
        System.out.println("가 최종 우승했습니다.");
    }


    private final MainInput input;

    public Main(MainInput input) {
        this.input = input;
    }


    public CarRacing.GameResult playGame() {
        CarRacing racing = input.createGame();

        for (int i = 0; i < racing.gameCount; i++) {
            racing.progressOnce();
            printGameState(racing);
        }

        return racing.getResult();
    }

    private void printGameState(CarRacing racing) {
        for (Car car : racing.cars) {
            printCarState(car);
        }
        
        System.out.println();
    }

    private void printCarState(Car car) {
        System.out.print(car.getName());

        System.out.print(" : ");

        int position = car.getPosition();
        if (position >= 0) {
            String positionIndicator = "-".repeat(position);
            System.out.print(positionIndicator);
        } else {
            System.out.print("");
        }

        System.out.println();
    }


}
