package step3.component;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.NumberValidator;

class NumberValidatorTest {

    @Test
    @DisplayName("자동차 수가 1보다 작게 입력되면 예외를 발생시킨다.")
    void carAmountIsGtZero() {
        // given
        int carAmount = 0;

        // when&then
        Assertions.assertThatThrownBy(() -> NumberValidator.validateCarAmount(carAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 1보다 작게 입력되면 예외를 발생시킨다.")
    void tryNumberIsGtZero() {
        // given
        int tryNumber = -1;

        // when&then
        Assertions.assertThatThrownBy(() -> NumberValidator.validateTryNumber(tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상만 입력이 가능합니다");
    }

    @Test
    @DisplayName("자동차 수가 1보다 크거나 같으면 예외를 발생시키지 않는다.")
    void carAmountIsGteOne() {
        // given
        int carAmount = 1;

        // when&then
        Assertions.assertThatCode(() -> NumberValidator.validateCarAmount(carAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 1보다 크거나 같으면 예외를 발생시키지 않는다.")
    void tryNumberIsGteZero() {
        // given
        int tryNumber = 1;

        // when&then
        Assertions.assertThatCode(() -> NumberValidator.validateTryNumber(tryNumber))
                .doesNotThrowAnyException();
    }
}