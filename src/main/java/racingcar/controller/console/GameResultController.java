package racingcar.controller.console;

import racingcar.view.GameResultView;

public class GameResultController {

    public void printResult(GameResultView view) {
        String winnerNames = String.join(", ", view.getWinnerNames());

        System.out.print(winnerNames);
        System.out.println("가 최종 우승했습니다.");
    }

}
