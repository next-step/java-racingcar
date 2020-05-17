package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorSymbolTest {

    private CalculatorSymbol calculatorSymbol;
    private int firstNum = 4;
    private int secondNum = 2;

    @BeforeEach
    void setUp() {
        calculatorSymbol = CalculatorSymbol.getInstance();
    }

    @DisplayName("더하기 테스트")
    @Test
    void findTypeAndAdd() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "+");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("빼기 테스트")
    @Test
    void findTypeAndSubtract() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "-");
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void findTypeAndDivision() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "/");
        assertThat(result).isEqualTo(2);

    }

    @DisplayName("곱셈 테스트")
    @Test
    void findTypeAndMultiply() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "*");
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("잘못된 연산부호 테스트")
    @Test
    void findTypeAndSymbolErrorInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, ")"));
    }

    @DisplayName("잘못된 분모 값 나누셈 테스트")
    @Test
    void findTypeAndDivisiondwithZero() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculatorSymbol.findTypeAndCalculator(firstNum, 0, "/"))
                .withMessage("분모가 0일수 없습니다.");
    }

}