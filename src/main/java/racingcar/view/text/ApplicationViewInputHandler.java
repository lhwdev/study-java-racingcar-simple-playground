package racingcar.view.text;

import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;


public class ApplicationViewInputHandler {

    public ApplicationViewInput promptInput(PromptHandler handler) {
        List<Car.Name> carNames = promptCarNames(handler);
        int gameCount = promptGameCount(handler);

        return new ApplicationViewInput(carNames, gameCount);
    }

    List<Car.Name> promptCarNames(PromptHandler handler) {
        String str = handler.prompt("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        try {
            return Stream.of(str.split(","))
                    .map(String::trim)
                    .map(Car.Name::new)
                    .toList();
        } catch (Exception e) {
            throw new ParseException("자동차 이름", e);
        }
    }

    int promptGameCount(PromptHandler handler) {
        String str = handler.prompt("시도할 횟수는 몇회인가요?");

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new ParseException("게임 횟수", e);
        }
    }


    public static class ParseException extends RuntimeException {

        public ParseException(String name, Throwable cause) {
            super(name + " 파싱에 실패했습니다.", cause);
        }

    }

}
