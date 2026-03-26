package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;


public class GameResultView {

    private final CarRacing.GameResult result;


    public GameResultView(CarRacing.GameResult result) {
        this.result = result;
    }


    public List<String> getWinnerNames() {
        return result.winners().stream()
                .map(Car::getName)
                .toList();
    }

}
