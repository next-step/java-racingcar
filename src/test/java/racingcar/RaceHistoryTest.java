package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceHistoryTest {

    @Test
    void record_라운드_결과를_기록한다() {
        RoundResult result = new RoundResult(List.of(1, 0));
        RaceHistory history = new RaceHistory();

        history.record(result);

        assertThat(history.getRound(0).positions()).containsExactly(1, 0);
    }
}
