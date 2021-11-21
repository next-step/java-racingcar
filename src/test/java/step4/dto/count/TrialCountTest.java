package step4.dto.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2})
    @DisplayName("1 미만의 갑을 인자로 받을 시 예외를 던진다")
    public void validTest(int input) {
        assertThatThrownBy(() -> {
            new TrialCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
