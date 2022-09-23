package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    @Test
    @DisplayName("숫자가 없을 경우 예외가 발생한다")
    void noneNumberThrowExceptionTest() {
        assertThatThrownBy(() -> new UserInput("test"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 없습니다.");
    }

    @Test
    @DisplayName("음수를 전달할 경우 예외가 발생한다")
    void hasMinusThrowException() {
        assertThatThrownBy(() -> new UserInput("3,-1,2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("빈 값일 경우 0을 반환한다")
    void emptyStringTest() {
        //given
        UserInput numbers = new UserInput("");
        StringCalculator stringCalculator = new StringCalculator(numbers);

        //when
        int sum = stringCalculator.calculate();

        //then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값일 경우 0을 반환한다")
    void nullStringTest() {
        //given
        UserInput numbers = new UserInput(null);
        StringCalculator stringCalculator = new StringCalculator(numbers);

        //when
        int sum = stringCalculator.calculate();

        //then
        assertThat(sum).isEqualTo(0);
    }

}