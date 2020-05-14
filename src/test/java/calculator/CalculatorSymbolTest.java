package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorSymbolTest {

    private CalculatorSymbol calculatorSymbol;

    @BeforeEach
    void setUp() {
        calculatorSymbol = new CalculatorSymbol();
    }

    @DisplayName("계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:2", "/:2", "*:8"}, delimiter = ':')
    void findTypeAndCalculator(String input, int expected) {
        int result = calculatorSymbol.findTypeAndCalculator(4, 2, input);
        assertThat(result).isEqualTo(expected);
    }
}