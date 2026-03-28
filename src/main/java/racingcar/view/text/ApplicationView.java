package racingcar.view.text;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarRacing;


public class ApplicationView implements TextNode.Sections {

    private final List<ProgressionView> progressions;
    private final GameResultView result;

    public ApplicationView(CarRacing.GameResult result) {
        this.progressions = result.progressions().stream()
                .map(progression -> new ProgressionView(progression.cars()))
                .toList();

        this.result = new GameResultView(result.winners());
    }

    @Override
    public List<TextNode> content() {
        List<TextNode> nodes = new ArrayList<>();
        nodes.addAll(progressions);
        nodes.add(result);
        return nodes;
    }

}
