package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.utils.RaceTestStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @DisplayName("차가 전진하는 조건을 항상 참으로 하면 전진한다")
    @Test
    void randomConditionIsAlwaysTrue() {
        RaceTestStrategy raceRule = new RaceTestStrategy();
        assertThat(raceRule.isValidForGoForward()).isTrue();
    }

}
