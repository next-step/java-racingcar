package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingSessionTest {

    @Test
    @DisplayName("입력받은 수만큼 턴 행동")
    void 턴_행동() {
        RacingSession session = RacingSession.of("a,b");

        List<TurnSnapshot> positions = session.startRacing(5);

        assertThat(positions).hasSize(5);
        for (TurnSnapshot position : positions) {
            assertThat(position.getCarPositions()).hasSize(2);
        }
    }

}
