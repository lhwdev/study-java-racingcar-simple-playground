package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.domain.Position;


/**
 * 자동차 경주에서, 한 회차 이후의 상태를 보여줍니다.
 * <p>
 * 한번 차를 전진시킨 후에는 차의 위치와 같은 정보를 보여주기 위해 저장해야 하는데, 해당 정보가 이 클래스에 저장되어 있습니다.
 */
public class ProgressionView {

    public static class CarProgression {

        public String name;
        public int position;

        public CarProgression(Car.Name name, Position position) {
            this.name = name.value();
            this.position = position.get();
        }

    }


    public List<CarProgression> cars;


    public ProgressionView(CarRacing from) {
        this.cars = from.cars.stream()
                .map(car -> new CarProgression(car.name, car.position))
                .toList();
    }

}
