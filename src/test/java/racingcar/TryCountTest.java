package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;
import racingcar.exception.TryCountException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @ParameterizedTest
    @DisplayName("TryCount 생성 예외 test")
    @ValueSource(ints = {0, -1, -2})
    void createTryCountTest(int count) {
        assertThatThrownBy(() -> TryCount.from(count)).isInstanceOf(TryCountException.class);
    }

    @ParameterizedTest
    @DisplayName("TryCount counting test")
    @MethodSource
    void countingTest(TryCount tryCount, TryCount expected) {
        tryCount.counting();

        assertThat(tryCount).isEqualTo(expected);
    }

    static Stream<Arguments> countingTest() {
        return Stream.of(
                Arguments.of(
                        TryCount.from(1), TryCount.from(2)
                ),
                Arguments.of(
                        TryCount.from(2), TryCount.from(3)
                ),
                Arguments.of(
                        TryCount.from(10), TryCount.from(11)
                )
        );
    }
}