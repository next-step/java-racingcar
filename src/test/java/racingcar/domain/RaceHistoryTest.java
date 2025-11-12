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

    @Test
    void winners_경주_기록이_존재하지않으면_예외발생() {
        RaceHistory history = new RaceHistory();

        assertThatThrownBy(history::winners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("경주 기록이 존재하지 않습니다.");
    }

    @Test
    void winners_여러_라운드_중_마지막_라운드의_우승자만_반환한다() {
        RaceHistory history = new RaceHistory();

        history.record(new RoundResult(
                List.of(new CarSnapshot("apple", 0), new CarSnapshot("banana", 0), new CarSnapshot("orange", 0))));

        history.record(new RoundResult(
                List.of(new CarSnapshot("apple", 0), new CarSnapshot("banana", 1), new CarSnapshot("orange", 0))));

        List<String> winners = history.winners();

        assertThat(winners).containsExactly("banana");
    }
}
