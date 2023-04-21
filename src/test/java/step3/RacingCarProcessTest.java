package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarProcessTest {
    private final int TEST_POSITIVE_ONE = 1;
    private final int TEST_NEGATIVE_ONE = -1;

    @Test
    void 음수입력시_예외처리() {
        {
            assertThatThrownBy(() -> new RacingProcess(TEST_POSITIVE_ONE, TEST_NEGATIVE_ONE))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수는 입력할 수 없습니다.");
        }
        {
            assertThatThrownBy(() -> new RacingProcess(TEST_NEGATIVE_ONE, TEST_POSITIVE_ONE))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수는 입력할 수 없습니다.");
        }

    }

}
