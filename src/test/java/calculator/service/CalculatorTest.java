package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Formula;
import calculator.domain.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @DisplayName("복합 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3 - 5:-1", "5 * 4 / 2:10"}, delimiter = ':')
    void run(String formula, double expected){
        double result = Calculator.run(new Formula(formula));
        assertThat(result).isEqualTo(expected);
    }
}