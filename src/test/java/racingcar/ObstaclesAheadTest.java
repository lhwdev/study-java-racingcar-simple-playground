package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.ObstaclesAhead.Result;


@SuppressWarnings("NonAsciiCharacters")
public class ObstaclesAheadTest {

    @Nested
    public class ByRandomTest {

        @ParameterizedTest
        @ValueSource(longs = {0, 1, 2, 3, 4})
        void 장애물을_피할_수_있다(long seed) {
            ObstaclesAhead avoidance = new ObstaclesAhead.ByRandom(seed);
            assertThat(asStream(avoidance)).contains(Result.AVOIDED, Result.BLOCKED);
        }
    }


    private Stream<ObstaclesAhead.Result> asStream(ObstaclesAhead avoidance) {
        return Stream.generate(avoidance::tryAvoid)
                .limit(10);
    }
}
