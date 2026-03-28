package racingcar.view.text;

import java.util.List;
import racingcar.domain.Car;


public class GameResultView implements TextNode.Leaf {

    private final List<Car> winners;


    public GameResultView(List<Car> winners) {
        this.winners = winners;
    }


    @Override
    public List<String> lines() {
        return List.of(line());
    }

    private String line() {
        StringBuilder str = new StringBuilder();

        for (Car winner : winners) {
            str.append(winner.getName());
        }

        str.append("가 최종 우승했습니다.");
        return str.toString();
    }

}
