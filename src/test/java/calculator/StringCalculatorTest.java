package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("\"1 + 1\" 입력 시, 덧셈 결과 2 출력")
    public void addition() {
        int calculateResult = stringCalculator.execute("1 + 1");
        assertEquals(calculateResult, 2);
    }

    @Test
    @DisplayName("\"2 - 1\" 입력 시, 뺄셈 결과 1 출력")
    public void subtraction() {
        int calculateResult = stringCalculator.execute("2 - 1");
        assertEquals(calculateResult, 1);
    }

    @Test
    @DisplayName("\"2 * 2\" 입력 시, 곱셈 결과 4 출력")
    public void multiplication() {
        int calculateResult = stringCalculator.execute("2 * 2");
        assertEquals(calculateResult, 4);
    }

    @Test
    @DisplayName("\"5 / 2\" 입력 시, 나눗셈 결과 2 출력")
    public void division() {
        int calculateResult = stringCalculator.execute("5 / 2");
        assertEquals(calculateResult, 2);
    }

}