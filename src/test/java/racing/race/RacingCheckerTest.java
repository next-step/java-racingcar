package racing.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.Constants;
import racing.race.RacingChecker;

public class RacingCheckerTest {

    RacingChecker checker = new RacingChecker();

    @Test
    void test_is_forward() {
        Assertions.assertThat(checker.isForward(Constants.MIN_NUM_OF_FORWARD)).isTrue();
    }

    @Test
    void test_is_not_forward() {
        Assertions.assertThat(checker.isForward(Constants.MIN_NUM_OF_FORWARD - 1)).isFalse();
    }
}
