package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("주어진 횟수만큼 경기를 진행한다.")
    void racing() {
        final String[] carNames = {"pobi", "crong", "honux"};
        final int attemptsCount = 5;

        final Racing racing = new Racing(carNames, attemptsCount);

        int raceCount = 0;
        while (racing.racing()) {
            racing.runRace();
            raceCount++;
        }

        assertThat(raceCount).isEqualTo(attemptsCount);
    }
}
