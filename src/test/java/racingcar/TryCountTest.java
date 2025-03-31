package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

public class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    @DisplayName("tryCount 초기화 실패")
    public void failed(String tryCountString) {
        assertThatThrownBy(() -> new TryCount(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}
