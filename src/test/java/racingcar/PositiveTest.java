package racingcar;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {

    public static final int ZERO_NUMBER = 0;
    private static final int NEGATIVE_NUMBER = -1;
    private static final String EXPECTED_ERROR_MESSAGE = "양수만 입력할 수 있습니다.";

    @ParameterizedTest
    @DisplayName("Positive 생성자 사용시 0이하의 수가 입력되면 NotPositiveNumberException이 발생한다.")
    @ValueSource(ints = {ZERO_NUMBER, NEGATIVE_NUMBER})
    public void positive_zero(int value) {
        ThrowableAssert.ThrowingCallable actual = () -> new Positive(value);

        assertThatThrownBy(actual)
                .isInstanceOf(NotPositiveNumberException.class)
                .hasMessageContaining(EXPECTED_ERROR_MESSAGE);
    }
}
