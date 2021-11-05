package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @ParameterizedTest
    @DisplayName("TryCount 생성 예외 test")
    @ValueSource(ints = {0, -1, -2})
    void createTryCountTest(int count) {
        assertThatThrownBy(() -> TryCount.from(count)).isInstanceOf(TryCountException.class);
    }

}