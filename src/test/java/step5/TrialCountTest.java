package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.dto.TrialCount;

class TrialCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2, -4})
    @DisplayName("시도 횟수는 0 이하의 값을 받을 경우 예외를 던진다")
    public void trialException(int input) {
        Assertions.assertThatThrownBy(() -> {
            new TrialCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
