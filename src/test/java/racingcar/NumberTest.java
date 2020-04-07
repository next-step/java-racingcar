package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {

    @DisplayName(value = "숫자를 입력할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void numberCreate(final String textInput) {
        assertThat(new Number(textInput).getNumber()).isEqualTo(1);
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Number(textInput));
    }

    @DisplayName(value = "숫자가 아닌값 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "B", "*"})
    void checkNotNumber(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Number(textInput));
    }

    @DisplayName(value = "0보다 작은 값을 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void underZero(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Number(textInput));
    }


}
