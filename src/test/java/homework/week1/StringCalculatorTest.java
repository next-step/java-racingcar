package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator strCal;
    private StringCalculator operStrCal;

    @BeforeEach
    void setUp() {
        strCal = new StringCalculator("2 + 3 * 4 / 2");
        operStrCal = new StringCalculator("2 + 3 * 4 / 2");
    }

    @DisplayName("입력값이 null, 빈문자열, 공백문자열 테스트")
    @Test
    void checkInputEmpty() {
        StringCalculator emptyInputStrCal = new StringCalculator("");
        StringCalculator whiteSpaceInputStrCal = new StringCalculator(" ");
        StringCalculator nullInputStrCal = new StringCalculator(null);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            emptyInputStrCal.checkInputEmpty();
            whiteSpaceInputStrCal.checkInputEmpty();
            nullInputStrCal.checkInputEmpty();
            strCal.checkInputEmpty();
        });
    }

    @DisplayName("공백문자 한개를 구분자로 입력 문자열 자르기 테스트")
    @Test
    void splitInput() {
        assertThat(strCal.splitInput().length).isEqualTo(7);
    }

    @DisplayName("문자열 배열의 최소 길이 3인지 테스트")
    @Test
    void checkMinLength() {
        StringCalculator minArrLengthStrCal = new StringCalculator("2 +");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            minArrLengthStrCal.checkMinLength(minArrLengthStrCal.splitInput());
        });
    }

    @DisplayName("문자열 배열의 최소 길이가 홀수인지 테스트")
    @Test
    void checkOddLength() {
        StringCalculator evenArrLengthStrCal= new StringCalculator("2 + 3 3");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            evenArrLengthStrCal.checkOddLength(evenArrLengthStrCal.splitInput());
        });
    }

    @DisplayName("문자열 배열의 첫번째 요소가 숫자형인지 테스트")
    @Test
    void checkFirstNumberValue() {
        StringCalculator invalidFirstValueStrCal = new StringCalculator("+ + 2");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidFirstValueStrCal.checkFirstAndLastNumberValues(invalidFirstValueStrCal.splitInput());
        });
    }

    @DisplayName("문자열 배열의 마지막 요소가 숫자형인지 테스트")
    @Test
    void checkLastNumberValue() {
        StringCalculator invalidFirstValueStrCal = new StringCalculator("2 + +");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidFirstValueStrCal.checkFirstAndLastNumberValues(invalidFirstValueStrCal.splitInput());
        });
    }

    @DisplayName("0 번째 포함 짝수 인덱스의 문자열 배열요소로 숫자형 문자열 배열로 얻기 테스트")
    @Test
    void getNumerStrings() {
        List<String> numberStrings = strCal.getNumerStrings(strCal.splitInput());
        assertThat(numberStrings.size()).isEqualTo(4);

    }

    @DisplayName("홀수 인덱스의 문자열 배열요소로 사칙연산 기호 문자열 배열로 얻기 테스트")
    @Test
    void setOperationalSymbols() {
        strCal.setOperationalSymbols(strCal.splitInput());
        assertThat(strCal.getOperationalSymbols().size()).isEqualTo(3);
    }

    @DisplayName("숫자형 문자열인지 테스트")
    @Test
    void checkNumberString() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            strCal.checkNumberString("344/");
        });
    }

    @DisplayName("사칙연산 기호 문자열인지 테스트")
    @Test
    void checkOperationalSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            strCal.checkOperationalSymbol("?234");
        });
    }

    @DisplayName("0 번째 포함 짝수 인덱스의 문자열 배열요소가 숫자들로만 이루어져있는지 테스트")
    @Test
    void checkNumbers() {
        StringCalculator invalidNumbersStrCal = new StringCalculator("? + 2 * /");
        invalidNumbersStrCal.splitInput();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> numberStrings1 = invalidNumbersStrCal.getNumerStrings(invalidNumbersStrCal.splitInput());
            invalidNumbersStrCal.checkNumbers(numberStrings1);
        });

    }

    @DisplayName("홀수 인덱스의 문자열 배열요소가 사칙연산 기호로만 이루어져있는지 테스트")
    @Test
    void checkOperationalSymbols() {
        StringCalculator invalidOperSymbolStrCal = new StringCalculator("2 3 2 + 4");
        invalidOperSymbolStrCal.splitInput();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidOperSymbolStrCal.setOperationalSymbols(invalidOperSymbolStrCal.splitInput());
            invalidOperSymbolStrCal.checkOperationalSymbols();
        });
    }

    @Test
    void setNumbers() {
        List<String> numberStrings = strCal.getNumerStrings(strCal.splitInput());
        strCal.setNumbers(numberStrings);
        assertThat(strCal.getNumbers().size()).isEqualTo(numberStrings.size());
    }

    @Test
    void plus() {
        int result = 1;
        result = operStrCal.plus(result,3, StringCalculator.PLUS_SYMBOL);
        result = operStrCal.plus(result,3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void minus() {
        int result = 1;
        result = operStrCal.minus(result, 3, StringCalculator.MINUS_SYMBOL);
        result = operStrCal.minus(result, 3, StringCalculator.PLUS_SYMBOL);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void multiply() {
        int result = 1;
        result = operStrCal.multiply(result, 3, StringCalculator.MULTIPLY_SYMBOL);
        result = operStrCal.multiply(result, 3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void division() {
        int result = 3;
        result = operStrCal.division(result, 3, StringCalculator.DIVISION_SYMBOL);
        result = operStrCal.division(result, 3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void calculate() {
        strCal.prepareForCalculate(strCal);
        assertThat(strCal.calculate()).isEqualTo(10);
    }
}
