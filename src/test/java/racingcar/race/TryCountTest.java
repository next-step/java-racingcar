package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @DisplayName("음수는 입력할 수 없다")
    @ValueSource(ints = {-1, -2})
    void negative(int tryCount) {
        Assertions.assertThatThrownBy(
                () -> {
                    TryCount trys = new TryCount(tryCount);
                }).isInstanceOf(RuntimeException.class).hasMessageContaining("0보다 큰 수를 입력하세요");
    }
}