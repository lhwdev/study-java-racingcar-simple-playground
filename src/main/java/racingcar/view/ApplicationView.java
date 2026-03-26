package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarRacing;


public record ApplicationView(
        List<ProgressionView> progressions,
        GameResultView result) {

    public static ApplicationView playGame(ViewInput input) {
        CarRacing racing = input.createGame();

        List<ProgressionView> progressions = new ArrayList<>();
        for (int i = 0; i < racing.gameCount; i++) {
            racing.progressOnce();

            ProgressionView progression = new ProgressionView(racing);
            progressions.add(progression);
        }

        GameResultView result = new GameResultView(racing.getResult());

        return new ApplicationView(progressions, result);
    }

}
