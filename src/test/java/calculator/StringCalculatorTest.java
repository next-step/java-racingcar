package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    @Test
    @DisplayName("\"1 + 1\" 입력 시, 덧셈 결과 2 출력")
    public void addition() {
        int calculateResult = StringCalculator.execute("1 + 1");
        assertEquals(calculateResult, 2);
    }

    @Test
    @DisplayName("\"2 - 1\" 입력 시, 뺄셈 결과 1 출력")
    public void subtraction() {
        int calculateResult = StringCalculator.execute("2 - 1");
        assertEquals(calculateResult, 1);
    }

    @Test
    @DisplayName("\"2 * 2\" 입력 시, 곱셈 결과 4 출력")
    public void multiplication() {
        int calculateResult = StringCalculator.execute("2 * 2");
        assertEquals(calculateResult, 4);
    }

    @Test
    @DisplayName("\"5 / 2\" 입력 시, 나눗셈 결과 2 출력")
    public void division() {
        int calculateResult = StringCalculator.execute("5 / 2");
        assertEquals(calculateResult, 2);
    }

    @Test
    @DisplayName("\"5 + 2 / 2 - 1 * 5\" 입력 시, 복합 연산 결과 10 출력")
    public void compoundOperation() {
        int calculateResult = StringCalculator.execute("5 + 2 / 2 - 1 * 5");
        assertEquals(calculateResult, 10);
    }

    @Test
    @DisplayName("\"1 ( 1\"입력 시, IllegalArgumentException 발생")
    public void shapeNotFoundOfIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.execute("1 ( 1"));
    }

    @Test
    @DisplayName("\"null\"입력 시, IllegalArgumentException 발생")
    public void failFunctionOfIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.execute(null));
    }

    @Test
    @DisplayName("\" \" 입력 시, IllegalArgumentException 발생")
    public void blankStringOfIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.execute(" "));
    }
}