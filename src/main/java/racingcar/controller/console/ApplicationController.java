package racingcar.controller.console;

import racingcar.view.ApplicationView;
import racingcar.view.ProgressionView;
import racingcar.view.ViewInput;


public class ApplicationController {

    private final InputController inputController = new InputController();
    private final ProgressionController progressionController = new ProgressionController();
    private final GameResultController gameResultController = new GameResultController();


    public void playCarRacing() {
        ViewInput input = inputController.promptAndRead();

        ApplicationView application = ApplicationView.playGame(input);

        for (ProgressionView progression : application.progressions()) {
            progressionController.printProgression(progression);
        }

        gameResultController.printResult(application.result());
    }

}
