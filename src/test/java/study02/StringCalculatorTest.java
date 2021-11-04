package study02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test01")
    @DisplayName("테스트01_문자열분리테스트 - 수식이 잘 분리되는지 테스트")
    void Test01_문자열분리테스트(String formula, Operand[] resultOperands, Operator[] resultOperators) {
        StringCalculator stringCalculator = new StringCalculator(formula);

        assertThat(stringCalculator.getOperandStack()).containsExactly(resultOperands);
        assertThat(stringCalculator.getOperatorStack()).containsExactly(resultOperators);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+ 1", "3 % 2", "-1 + +1 *0"})
    @DisplayName("테스트02_문자열분리실패테스트 - 수식이 분리 과정에서 에러 발생 테스트")
    void Test02_문자열분리실패테스트(String strings) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Formula(strings));
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test03")
    @DisplayName("Test03_피연산자두개덧셈 - 두개의 피연산자에 대한 덧셈이 수행되는지 테스트")
    void Test03_피연산자두개덧셈(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test04")
    @DisplayName("Test04_피연산자두개뺄셈 - 두개의 피연산자에 대한 뺄셈이 수행되는지 테스트")
    void Test04_피연산자두개뺄셈(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test05")
    @DisplayName("Test05_피연산자두개곱셈 - 두개의 피연산자에 대한 곱셈이 수행되는지 테스트")
    void Test05_피연산자두개곱셈(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test06")
    @DisplayName("Test06_피연산자두개나눗셈 - 두개의 피연산자에 대한 나눗셈이 수행되는지 테스트")
    void Test06_피연산자두개나눗셈(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test07")
    @DisplayName("Test07_피연산자세개이상의단일연산자 - 세개 이상의 피연산자로 동일한 연산을 수행")
    void Test07_피연산자세개이상의단일연산자(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("study02.StringCalculatorResultValue#Test08")
    @DisplayName("Test08_피연산자세개이상의다중연산자 - 세개 이상의 피연산자로 다양한 연산을 수행")
    void Test08_피연산자세개이상의다중연산자(String formula, long result) {
        StringCalculator stringCalculator = new StringCalculator(formula);
        assertThat(stringCalculator.calculate().getValue()).isEqualTo(result);
    }

    @Test
    @DisplayName("Test09_비정상입력테스트 - null 테스트")
    void Test09_비정상입력테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Formula(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      ", "2 2", "+ -", "2 3 1 +"})
    @DisplayName("Test10_비정상입력테스트 - 빈문자, 갯수 부족 테스트")
    void Test10_비정상입력테스트(String strings) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Formula(strings));
    }

    @Test
    @DisplayName("Test11_0으로나누기테스트 - 0으로 나눴을 때 예외발생 검사")
    void Test11_0으로나누기테스트() {
        StringCalculator stringCalculator = new StringCalculator("2 + 4 / 0");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringCalculator.calculate().getValue());
    }
}
