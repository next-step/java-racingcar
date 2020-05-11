package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("String input이 Null이거나 Empty일 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void testThrowExceptionWhenStringNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Calculator calculator = new Calculator();
                   calculator.run(input);
                });
    }
}