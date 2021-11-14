package edu.nextstep.camp.calculator;

import java.util.Arrays;
import java.util.Iterator;

import edu.nextstep.camp.calculator.Calculator;
import edu.nextstep.camp.calculator.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    final Calculator cal = new Calculator();

    @ParameterizedTest(name = "test invalid input: {arguments}")
    @NullSource
    @EmptySource
    public void testInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(input));
    }

    @ParameterizedTest(name = "test simple calculate: {arguments}")
    @CsvSource(value = {"3 + 5,8", "8 - 3,5", "5 * 3,15", "5  * 3,15"})
    public void testSimpleCalculate(String command, int expected) {
        assertThat(cal.calculate(command)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "test complicate calculate: {arguments}")
    @CsvSource(value = {
            "2 + 3 * 4 / 2,10",
            "3 + 5 * 7 - 2,54",
            "8 - 3 / 2 * 4, 8",
            "5 * 3 + 4 / 2 + 14 - 3 * 2 + 5 / 2,22"
    })
    public void testComplicateCalculate(String command, int expected) {
        assertThat(cal.calculate(command)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "test parse invalid input: {arguments}")
    @NullSource
    @EmptySource
    @ValueSource(strings = {
            "1 2", // 숫자만 두개
            "1 2 3", // 숫자만 세개
            "+", // 연산자만
            "3", // 숫자만
            "3-3", // 띄어쓰기 없음
            "3 + - 3", // 연산자가 연속으로 두개
            "4 - 1 /", // 마지막에 연산자로 끝남
            "3 # 5", // 이상한 연산자 #1
            "5 not-a-operator 3" // 이상한 연산자 #2
    })
    public void testParseInvalidCommand(String invalid) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.parseCommand(invalid));
    }

    @ParameterizedTest(name = "test parse input: {arguments}")
    @CsvSource(value = {
            "8 - 3,8;-;3", // 간단한 수식
            "5  * 3,5;*;3",  // 띄어쓰기 두개 허용
            "5 * 3 + 4 / 2 + 14 - 3 * 2 + 5 / 2,5;*;3;+;4;/;2;+;14;-;3;*;2;+;5;/;2" // 복잡한 수식
    })
    public void testParseCommand(String command, String expected) {
        assertThat(String.join(";", cal.parseCommand(command))).isEqualTo(expected);
    }

    @Test
    public void testCalculateRecursive() {
        final Number n = Number.of(2);
        final String[] input = {"+", "4", "+", "8", "/", "2"};
        final Iterator<String> iter = Arrays.stream(input).iterator();
        assertThat(cal.calculateRecursive(n, iter)).isEqualTo(Number.of(7));
    }
}
