package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void calculatorTest_nullTest() {
        Assertions.assertThat(Calculator.sum(null)).isEqualTo(0);
    }

    @Test
    void calculatorTest_emptyStringTest() {
        Assertions.assertThat(Calculator.sum("")).isEqualTo(0);
    }

    @Test
    void calculatorTest_oneNumberTest() {
        Assertions.assertThat(Calculator.sum("1")).isEqualTo(1);
    }

    @Test
    void calculatorTest_twoNumberWithCommaTest() {
        Assertions.assertThat(Calculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    void calculatorTest_numbersWithCommaAndColonsTest() {
        Assertions.assertThat(Calculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    void calculatorTest_customSplitTest() {
        Assertions.assertThat(Calculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void calculatorTest_negativeNumberTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.sum("-1,2"));
    }

    @Test
    void calculatorTest_notNumberTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.sum("abc,def"));
    }

    @Test
    void calculatorTest_whiteSpaceTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.sum(" ,1"));
    }

    @Test
    void calculatorTest_commaTest() {
        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Calculator.sum(","));
    }

    @Test
    void calculatorTest_multipleSplitTest() {
        Assertions.assertThat(Calculator.sum("//;\n1,2:3;4")).isEqualTo(10);
    }
}
