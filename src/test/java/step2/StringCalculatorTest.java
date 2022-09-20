package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 덧셈 계산기 클래스 생성 테스트")
    void constructorTest() {
        //given
        String numbers = "1,2:3";

        //then
        assertDoesNotThrow(() -> new StringCalculator(numbers));
    }

    @Test
    @DisplayName("숫자가 없을 경우 예외가 발생한다")
    void noneNumberThrowExceptionTest() {
        //given
        String numbers = "test";
        //then
        assertThatThrownBy(() -> new StringCalculator(numbers))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 없습니다.");
    }

    @Test
    @DisplayName("음수를 전달할 경우 예외가 발생한다")
    void hasMinusThrowException() {
        //given
        String numbers = "3,-1,2";

        //then
        assertThatThrownBy(() -> new StringCalculator(numbers))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("빈 값일 경우 0을 반환한다")
    void emptyStringTest() {
        //given
        String numbers = "";
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
        String numbers = null;
        StringCalculator stringCalculator = new StringCalculator(numbers);

        //when
        int sum = stringCalculator.calculate();

        //then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표 콜론 문자열 자르기")
    void splitStringTest() {
        //given
        String numbers = "1:2:3:4,5";
        StringCalculator stringCalculator = new StringCalculator(numbers);

        //when
        int sum = stringCalculator.calculate();

        //then
        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("구분자 지정하기")
    void customSeparatorTest() {
        //given
        String numbers = "//;\n1;2;3";
        StringCalculator stringCalculator = new StringCalculator(numbers);

        //when
        int sum = stringCalculator.calculate();

        //then
        assertThat(sum).isEqualTo(6);

    }
}
