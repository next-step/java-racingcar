package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void 환경설정(){
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "7 + 8 + 5,20"})
    void 덧셈_기능_확인(String expression, int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2,-1", "5 - 3,2", "10 - 1 - 4,5"})
    void 뺄셈_기능_확인(String expression, int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2,2", "5 * 3,15", "10 * 2 * 3,60"})
    void 곱셈_기능_확인(String expression, int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2,2", "10 / 2,5", "12 / 2 / 3,2"})
    void 나눗셈_기능_확인(String expression, int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @Test
    void 나눗셈_분모가_0인경우_오류발생(){
        assertThatThrownBy(()->stringCalculator.calculate("4 / 0"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("나눗셈의 분모는 0이면 안됩니다.");
    }

    @Test
    void 입력값이_빈공백_대한_오류검증(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->stringCalculator.calculate("")
        ).withMessage("입력은 공백이면 안됩니다.");
    }

    @Test
    void 입력값이_null_대한_오류검증(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->stringCalculator.calculate(null)
        ).withMessage("입력은 공백이면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 % 1", "5 & 2"})
    void 사칙연산기호가_아닌_경우_오류검증(String expression){
        assertThatIllegalArgumentException().isThrownBy(
                ()->stringCalculator.calculate(expression)
        ).withMessage("사칙 연산 기호가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 / 3, 1"
            , "4 - 2 + 10 * 2,24"
            , "1 + 3 / 2 * 5,10"
            , "1 - 5 * 2,-8"
    })
    void 사칙연산_모두_포함_기능_검증(String expression, int expected){
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }


}
