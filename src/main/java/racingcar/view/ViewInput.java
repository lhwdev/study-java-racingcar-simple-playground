package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;


public class ViewInput {

    public final List<Car.Name> carNames;
    public final int gameCount;

    public ViewInput(List<Car.Name> carNames, int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }


    public CarRacing createGame() {
        return new CarRacing(carNames, gameCount);
    }

}
