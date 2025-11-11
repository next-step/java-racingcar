package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceHistoryTest {

    @Test
    void record_라운드_결과를_기록한다() {
        RoundResult result = new RoundResult(List.of(new CarSnapshot("자동차하나", 1), new CarSnapshot("자동차둘", 0)));
        RaceHistory history = new RaceHistory();

        history.record(result);

        assertThat(history.getRound(0).snapshots())
                .containsExactly(new CarSnapshot("자동차하나", 1), new CarSnapshot("자동차둘", 0));
    }
}
