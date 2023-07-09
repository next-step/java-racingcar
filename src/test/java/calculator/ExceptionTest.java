package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    @DisplayName("숫자 이외의 값 전달 시 IllegalArgumentException")
    void numberFormatException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.sum("//;\n1;2;a"));
    }

    @Test
    @DisplayName("음수 값 전달 시 IllegalArgumentException")
    void negativeNumberException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.sum("//;\n1;-2"));
    }

}
