package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static study.Step2.calculateString;

public class StringCalculatorTest {

    @Test
    @DisplayName("Test empty string check")
    void checkStringIsBlank() {
        int result = calculateString(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Test, split and add with general splitter")
    void generalSplitterStringAddCalc() {
        int result = calculateString("1,2,3");
        int result2 = calculateString("1,2:3");
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    @DisplayName("Test, split and add with custom splitter")
    void customSplitterStringAddCalc() {
        int result = calculateString("//-\n1-2-3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Test, an error occurs if it is a value other than a number.")
    void notNumberError() {
        // 일반 구분자일 때
        assertThrows(IllegalArgumentException.class, () -> calculateString("1;-;3"));

        //특수 구분자 일 떄
        assertThrows(IllegalArgumentException.class, () -> calculateString("//;\n1;-;3"));
    }

    @Test
    @DisplayName("Test, an error occurs if it is negative number.")
    void negativeNumberError() {
        // 일반 구분자일 때
        assertThrows(RuntimeException.class, () -> calculateString("1;-2;3"));

        // 특수 구분자 일 떄
        assertThrows(RuntimeException.class, () -> calculateString("//;\n1;-2;3"));
    }
}
