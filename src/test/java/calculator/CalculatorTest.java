package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void sum_NullOrEmpty(String text) {
        assertThat(new Calculator(text).sum()).isZero();
    }

    @Test
    public void sum_OneNumber() {
        assertThat(new Calculator("1").sum()).isEqualTo(1);
    }

    @Test
    public void sum_CommaDelimiter() {
        assertThat(new Calculator("1,2").sum()).isEqualTo(3);
    }

    @Test
    public void sum_CommaOrColonDelimiter() {
        assertThat(new Calculator("1,2:3").sum()).isEqualTo(6);
    }

    @Test
    public void sum_CustomDelimiter() {
        assertThat(new Calculator("//;\n1;2;3").sum()).isEqualTo(6);
    }

    @Test
    public void sum_NegativeValue() {
        assertThatThrownBy(() -> new Calculator("-1,2,3").sum())
                .isInstanceOf(RuntimeException.class);
    }
}
