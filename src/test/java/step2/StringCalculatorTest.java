package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @DisplayName("공백 기준으로 String 나누기")
    @Test
    void splitStringByWhiteSpace() {
        String given = "1 2 3 4";

        assertThat(stringCalculator.splitStringByWhiteSpace(given)).containsExactly("1","2","3","4");
    }

    @DisplayName("공백 기준으로 String을 나눌 때 유효한 값이 2개 이상이 아니면 IllegalArgumentException 발생")
    @Test
    void assertThrowIllegalArgumentExceptionOnSplitStringByWhiteSpace() {
        String given = "1234";
        assertThrows(IllegalArgumentException.class,()->stringCalculator.splitStringByWhiteSpace(given));
    }

    @DisplayName("문자열이 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings={""," ","   "})
    void assertIsNotNullOrEmpty(String string) {
        assertThrows(IllegalArgumentException.class,()->stringCalculator.validateIsNotNullOrEmpty(string));
    }

    @DisplayName("String 배열이 숫자가 아닌 값으로 시작하거나 끝나면 IllegalArgumentException 발생")
    @Test
    void assertExpressionStartOrEndNumber() {
        String[] given = new String[]{"-","1","+","2"};
        assertThrows(IllegalArgumentException.class,()->stringCalculator.validateExpressionStartOrEndNumber(given));
    }

    @DisplayName("String을 Integer로 변환")
    @Test
    void parseStringToInteger() {
        String given = "99";

        assertThat(stringCalculator.parseStringToInteger(given)).isEqualTo(99);
    }

    @DisplayName("String 배열을 Integer 배열로 변환")
    @Test
    void transformStringArrayToIntegerArray() {
        String[] given = new String[]{"1","2","3","4"};

        assertThat(stringCalculator.transformStringArrayToIntegerArray(given)).containsExactly(1,2,3,4);
    }

    @DisplayName("String 배열에서 숫자만 뽑아서 새로운 배열로 반환")
    @Test
    void filterNumberStringFromStringArray() {
        String[] given = new String[]{"1","+","3","*","4"};

        assertThat(stringCalculator.filterNumberStringFromStringArray(given)).containsExactly("1","3","4");
    }

    @DisplayName("String 배열에서 사칙연산 기호만 뽑아서 새로운 배열로 반환")
    @Test
    void filterOperatorStringFromStringArray() {
        String[] given = new String[]{"1","/","3","*","4","+","5","-","6"};

        assertThat(stringCalculator.filterOperatorStringFromStringArray(given)).containsExactly("/","*","+","-");
    }

    @DisplayName("주어진 두 수 덧셈")
    @Test
    void add() {
        Integer givenOne = 1;
        Integer givenTheOther = 2;
        assertThat(stringCalculator.add(givenOne,givenTheOther)).isEqualTo(3);
    }

    @DisplayName("주어진 두 수 뺄셈")
    @Test
    void subtract() {
        Integer givenOne = 2;
        Integer givenTheOther = 1;
        assertThat(stringCalculator.subtract(givenOne,givenTheOther)).isEqualTo(1);
    }

    @DisplayName("주어진 두 수 곱셈")
    @Test
    void multiply() {
        Integer givenOne = 1;
        Integer givenTheOther = 2;
        assertThat(stringCalculator.multiply(givenOne,givenTheOther)).isEqualTo(2);
    }

    @DisplayName("주어진 두 수 나눗셈")
    @Test
    void divide() {
        Integer givenOne = 5;
        Integer givenTheOther = 3;
        assertThat(stringCalculator.divide(givenOne,givenTheOther)).isEqualTo(1);
    }

    @DisplayName("0으로 나누면 IllegalArgumentException 발생")
    @Test
    void throwIllegalArgumentExceptionWhenDividingZero() {
        Integer givenOne = 5;
        Integer givenTheOther = 0;
        assertThrows(IllegalArgumentException.class,()->stringCalculator.divide(givenOne,givenTheOther));
    }

    @DisplayName("사칙연산 기호가 아닌 기호를 발견하면 IllegalArgumentException 발생")
    @Test
    void throwIllegalArgumentExceptionWhenGivenNonValidOperator() {
        Integer givenOne = 5;
        Integer givenTheOther = 0;
        String givenOperator = "&";
        assertThrows(IllegalArgumentException.class,()->stringCalculator.computeWithRightOperator(givenOne,givenTheOther,givenOperator));
    }

    @DisplayName("입력받은 식에 대해서 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 * 1 + 2 / 3 - 1:0"}, delimiter = ':')
    void calculate(String expression, Integer expectedResult) {
        String given = "2 + 3 * 4 / 2";

        assertThat(stringCalculator.calculate(expression)).isEqualTo(expectedResult);
    }

    @DisplayName("연산자가 올바르게 작성되지 않은 식에서 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2 + + 3 * 4", "1 + 3 - * 5"})
    void throwIllegalArgumentExceptionWhenGivenNonValidOperatorCount(String expression) {
        assertThrows(IllegalArgumentException.class,()->stringCalculator.calculate(expression));
    }

    //TODO: 아래 테스트 코드의 파라미터도 익셉션 던지게 바꾸기
    @Test
    void 끄기_전에_생각난_테스트코드() {
        String given = "2 2 + + 2";
        assertThat(stringCalculator.calculate(given)).isEqualTo(6);
    }

}