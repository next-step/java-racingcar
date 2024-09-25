package calculator;

import calculator.exception.NumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import calculator.number.Number;

import static calculator.exception.ErrorMessage.NON_NUMERICAL;
import static calculator.exception.ErrorMessage.NOT_ALLOWED_NEGATIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("[성공] 0이상의 숫자를 값으로 설정하여 객체를 생성할 수 있다.")
    void 생성테스트_01(final int number) {
        assertDoesNotThrow(() -> new Number(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    @DisplayName("[실패] 음수 숫자를 값으로 설정했을 때 객체 생성 시 에외가 발생한다.")
    void 생성테스트_02(final int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(NumberException.class)
                .hasMessageContaining(NOT_ALLOWED_NEGATIVE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    @DisplayName("[성공] 0이상의 문자열을 값으로 설정하여 객체를 생성할 수 있다.")
    void 생성테스트_03(final String number) {
        assertDoesNotThrow(() -> new Number(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    @DisplayName("[성공] 음수 문자열을 값으로 설정하여 객체를 생성할 수 있다.")
    void 생성테스트_04(final String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(NumberException.class)
                .hasMessageContaining(NOT_ALLOWED_NEGATIVE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"!"})
    @DisplayName("[실패] 숫자가 아닌 문자열을 값으로 설정했을 때 객체 생성 시 에외가 발생한다.")
    void 생성테스트_05(final String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(NumberException.class)
                .hasMessageContaining(NON_NUMERICAL.getMessage());
    }

    @Test
    @DisplayName("[성공] add 함수로 숫자를 더하면 더한 값을 가진 객체를 반환한다.")
    void add() {
        // given
        final var augend = new Number(10);
        final var addend = new Number(5);

        // when
        final var sum = augend.add(addend);

        // then
        assertThat(sum).isEqualTo(new Number(15));
    }

}
