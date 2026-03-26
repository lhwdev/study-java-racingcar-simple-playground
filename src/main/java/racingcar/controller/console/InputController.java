package racingcar.controller.console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.view.ViewInput;


public class InputController {

    public ViewInput promptAndRead() {
        Scanner in = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Car.Name> carNames = parseNames(in.nextLine());

        System.out.println("시도할 횟수는 몇회인가요?");
        int gameCount = in.nextInt();

        System.out.println();

        return new ViewInput(carNames, gameCount);
    }

    private static List<Car.Name> parseNames(String names) {
        String[] splitNames = names.split(",");
        return Stream.of(splitNames)
                .map(String::trim)
                .map(Car.Name::new)
                .toList();
    }

}
