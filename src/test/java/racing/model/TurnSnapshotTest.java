package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TurnSnapshotTest {

    @Test
    @DisplayName("턴 위치에서 가장 앞에 있는 차 찾기")
    void 해당턴_최고위치_차_찾기() {
        TurnSnapshot turnSnapshot = new TurnSnapshot(
                List.of(
                        new CarSnapshot("a", 5),
                        new CarSnapshot("b", 4),
                        new CarSnapshot("c", 5)
                )
        );
        List<String> winners = turnSnapshot.findMaxPositionCarNames();
        assertThat(winners).isEqualTo(List.of("a", "c"));
    }

}
