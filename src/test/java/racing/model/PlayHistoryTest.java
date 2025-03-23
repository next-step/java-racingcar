package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayHistoryTest {

    @Test
    @DisplayName("경기 기록에서 우승자 찾기")
    void 우승자_찾기() {
        List<TurnSnapshot> turnSnapshots = List.of(
                new TurnSnapshot(
                        List.of(
                                new CarSnapshot("a", 4),
                                new CarSnapshot("b", 4),
                                new CarSnapshot("c", 4)
                        )
                ),
                new TurnSnapshot(
                        List.of(
                                new CarSnapshot("a", 5),
                                new CarSnapshot("b", 4),
                                new CarSnapshot("c", 5)
                        )
                )
        );
        PlayHistory history = new PlayHistory(turnSnapshots);
        List<String> winners = history.findWinners();

        assertThat(winners).isEqualTo(List.of("a", "c"));
    }

}
