package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarProcessTest {
    private static final String TEST_CAR_NAME = "carTest";
    private static final int TEST_POSITIVE_ONE = 1;
    private final int TEST_NEGATIVE_ONE = -1;

    @Test
    void 음수입력시_예외처리() {
        {
            assertThatThrownBy(() -> new RacingProcess(TEST_CAR_NAME, TEST_NEGATIVE_ONE))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수는 입력할 수 없습니다.");
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_미입력시_예외처리(String input) {
        assertThatThrownBy(() -> new RacingProcess(input, TEST_POSITIVE_ONE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해 주세요");
    }

}
