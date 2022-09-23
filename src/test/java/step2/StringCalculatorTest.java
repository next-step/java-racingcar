package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 덧셈 계산기 클래스 생성 테스트")
    void constructorTest() {
        // given
        UserInput numbers = new UserInput("1,2:3");

        // then
        assertDoesNotThrow(() -> new StringCalculator(numbers));
    }

    @Test
    @DisplayName("쉼표 콜론 문자열 자르기")
    void splitStringTest() {
        // given
        UserInput numbers = new UserInput("1:2:3:4,5");
        StringCalculator stringCalculator = new StringCalculator(numbers);

        // when
        int sum = stringCalculator.calculate();

        // then
        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("구분자 지정하기")
    void customSeparatorTest() {
        // given
        UserInput numbers = new UserInput("//;\n1;2;3");
        StringCalculator stringCalculator = new StringCalculator(numbers);

        // when
        int sum = stringCalculator.calculate();

        // then
        assertThat(sum).isEqualTo(6);
    }
}
