package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static study.calculator.Common.*;

public class CalculatorTest {

    @DisplayName("변수 두개를 제공받아서 더하기 결과값 테스트.")
    @Test
    void plusTest() {
        assertThat(Calculator.plus(1, 2)).isEqualTo(3);
    }

    @DisplayName("변수 두개를 제공받아서 빼기 결과값 테스트.")
    @Test
    void minusTest() {
        assertThat(Calculator.minus(2, 1)).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 곱하기 결과값 테스트.")
    @Test
    void multiplyTest() {
        assertThat(Calculator.multiply(2, 3)).isEqualTo(6);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(몫) 결과값 테스트.")
    @Test
    void divisionShareTest() {
        assertThat(Calculator.divisionShare(2, 2)).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(나머지) 결과값 테스트.")
    @Test
    void divisionRemainderTest() {
        assertThat(Calculator.divisionRemainder(3, 1)).isEqualTo(0);
    }

    @DisplayName("변수가 null이거나 빈값인지 확인 후 IllegalArgumentException throw Test")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void valueIsNullOrBlankTest(String value) {
        //null이 들어간 경우,
        assertThrows(IllegalArgumentException.class, () -> checkValue(value));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw Test")
    @Test
    void operationTest() {
        assertThrows(IllegalArgumentException.class, () -> checkOperation("a"));
    }

    @DisplayName("Scanner 클래스를 활용해 입력된 값에 빈공백 기준으로 split 해서 수식 입력 바인딩 테스트.")
    @Test
    void inputValueSplitTest() {
        List<String> wordList = inputSplitValue("2 + 3");

        assertThat(wordList.size()).isEqualTo(3);
        assertThat(wordList).containsExactly("2", "+", "3");
    }

    @DisplayName("수식값 리스트에서 사용되는 숫자와 사칙연산 기호를 분리후 각각 리스트에 담기 테스트")
    @Test
    void bindingOperationTest() {
        List<String> wordList = inputSplitValue("2 + 3 - 1 * 2 / 8");

        Map<String, List<String>> map = Calculator.valueClassification(wordList);

        assertThat(map.get("values")).containsExactly("2", "3", "1", "2", "8");
        assertThat(map.get("operations")).containsExactly("+", "-", "*", "/");
    }

    @DisplayName("수식을 제공받아 구버전 연산 메소드로 결과를 도출.")
    @Test
    void calculateValueTest() {

        List<String> wordList = inputSplitValue("2 + 3 - 2 * 1 / 3");

        Map<String, List<String>> map = Calculator.valueClassification(wordList);
        assertThat(Calculator.getResult(map.get("values"), map.get("operations"))).isEqualTo(1);
    }

    @DisplayName("stream과 filter를 사용해서 연산자만 추려내는 테스트.")
    @Test
    void matchOperationsTest() {
        String data = "2 + 3 - 1 * 2 / 4";

        List<String> operations = Arrays.stream(data.split(" "))
                .filter(s -> s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                .collect(Collectors.toList());

        assertThat(operations).containsExactly("+", "-", "*", "/");
    }

    @DisplayName("stream과 filter를 사용해서 변수만 추려내는 테스트.")
    @Test
    void matchValuesTest() {
        String data = "2 + 3 - 1 * 2 / 4";

        List<String> values = Arrays.stream(data.split(" "))
                .filter(s -> !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
                .collect(Collectors.toList());

        assertThat(values).containsExactly("2", "3", "1", "2", "4");
    }

}
