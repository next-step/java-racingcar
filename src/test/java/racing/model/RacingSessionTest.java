package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import racing.model.Car;
import racing.model.CarPositions;
import racing.model.RacingSession;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingSessionTest {

    @Test
    @DisplayName("입력받은 수만큼 턴 행동")
    void 턴_행동() {
        RacingSession session = RacingSession.of("a,b");

        List<CarPositions> positions = session.startRacing(5);

        assertThat(positions).hasSize(5);
        for (CarPositions position : positions) {
            assertThat(position.getCarPositions()).hasSize(2);
        }
    }

}
