package racing.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.factories.RacingFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("주어진 횟수만큼 경기를 진행한다.")
    void racing() {
        final int carsCount = 3;
        final int attemptsCount = 5;

        final Racing racing = RacingFactory.createFrom(carsCount);

        int raceCount = 0;
        while (racing.hasRun(attemptsCount)) {
            racing.runRace();
            raceCount++;
        }

        assertThat(raceCount).isEqualTo(attemptsCount);
    }
}
