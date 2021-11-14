package racingcar.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LapTest {

    @DisplayName("각 라운드는 1미만일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -100})
    void createFail(int value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Lap.from(value);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("라운드는 최소 1이상이어야 합니다.");
    }
}
