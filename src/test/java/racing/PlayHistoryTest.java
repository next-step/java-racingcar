package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayHistoryTest {

    @Test
    @DisplayName("경기 기록에서 우승자 찾기")
    void 우승자_찾기() {
        List<String> carNames = List.of("a","b", "c");

        List<CarPositions> carPositionsAtTurn = List.of(
            new CarPositions(List.of(1,1,1)),
            new CarPositions(List.of(1,2,1)),
            new CarPositions(List.of(2,2,2)),
            new CarPositions(List.of(3,2,3))
        );
        PlayHistory history = new PlayHistory(carPositionsAtTurn);
        List<String> winners = history.findWinners(carNames);

        assertThat(winners).isEqualTo(List.of("a", "c"));
    }

}
