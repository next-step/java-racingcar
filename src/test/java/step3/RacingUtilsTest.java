package step3;

import org.junit.jupiter.api.Test;
import step3.utils.RacingUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingUtilsTest {
    private static final int TEST_MAX_BOUND = 10;

    @Test
    void 입력된_숫자가_4보다_큰지_작은지() {
        {
            boolean overLimit = RacingUtils.isOverLimit(5);
            assertTrue(overLimit);
        }
        {
            boolean overLimit = RacingUtils.isOverLimit(2);
            assertFalse(overLimit);
        }
    }

    @Test
    void 생성된_랜덤_숫자가_0_9_사이의_값인지() {
        int randomNumber = RacingUtils.generateRandomNumber(TEST_MAX_BOUND);

        assertTrue(0 <= randomNumber && randomNumber < 10);
    }

}
