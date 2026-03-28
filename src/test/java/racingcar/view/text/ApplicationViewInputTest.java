package racingcar.view.text;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;


@SuppressWarnings("NonAsciiCharacters")
public class ApplicationViewInputTest {

    private final ApplicationViewInputHandler inputHandler = new ApplicationViewInputHandler();

    @Test
    void 입력을_파싱할_수_있다() {
        PromptHandler prompt = new Prompts("a,b ,c", "5");
        ApplicationViewInput input = inputHandler.promptInput(prompt);
        assertThat(input.carNames())
                .map(Car.Name::value)
                .isEqualTo(List.of("a", "b", "c"));

        assertThat(input.gameCount())
                .isEqualTo(5);
    }

    @Test
    void 자동차_이름의_길이가_너무_길면_예외를_발생시킨다() {
        PromptHandler prompt = new Prompts("aefewfwefge,wefwergerge");
        assertThatThrownBy(() -> inputHandler.promptCarNames(prompt))
                .isInstanceOf(ApplicationViewInputHandler.ParseException.class)
                .hasMessageContaining("자동차 이름");
    }

    @Test
    void 게임_횟수가_숫자가_아니면_예외를_발생시킨다() {
        PromptHandler prompt = new Prompts("notNumber");
        assertThatThrownBy(() -> inputHandler.promptGameCount(prompt))
                .isInstanceOf(ApplicationViewInputHandler.ParseException.class)
                .hasMessageContaining("게임 횟수");
    }


    static class Prompts implements PromptHandler {

        private final Iterator<String> lines;

        public Prompts(String... lines) {
            this.lines = Arrays.asList(lines).iterator();
        }

        @Override
        public String prompt(String message) {
            return lines.next();
        }

    }

}
