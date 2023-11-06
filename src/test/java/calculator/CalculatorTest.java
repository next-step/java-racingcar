package calculator;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.DefaultDelimiter;
import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.operator.AddOperator;
import calculator.operator.MultiplyOperator;
import calculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("문자열 분리, 숫자 하나만 있는 경우 하나만 리턴, DefaultDelimiter를 이용한다")
    public void split_숫자하나() {
        String text = "1";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);

        assertThat(delimiter.parse(text)).containsExactly(text);
        assertThat(delimiter).isInstanceOf(DefaultDelimiter.class);
    }

    @Test
    @DisplayName("문자열 분리, 쉼표를 구분자로 숫자를 분리한다. DefaultDelimiter를 이용한다")
    public void split_쉼표구분자() {
        String text = "1,2";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);

        assertThat(delimiter.parse(text)).containsExactly("1", "2");
        assertThat(delimiter).isInstanceOf(DefaultDelimiter.class);
    }

    @Test
    @DisplayName("문자열 분리, 커스텀 구분자로 숫자를 분리한다. CustomDelimiter를 이용한다")
    public void split_custom_구분자() {
        String text = "//;\n1;2;3";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        assertThat(delimiter.parse(text)).containsExactly("1", "2", "3");
        assertThat(delimiter).isInstanceOf(CustomDelimiter.class);
    }

    @Test
    @DisplayName("연산자, 배열의 각 요소를 전부 더한다")
    public void operator_더하기() {
        Operator operator = new AddOperator();
        int result = operator.cal(Arrays.asList(1, 2, 3, 4));
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("연산자, 배열의 각 요스를 전부 곱한다")
    public void operator_곱하기() {
        Operator operator = new MultiplyOperator();
        int result = operator.cal(Arrays.asList(1, 2, 3, 4));
        assertThat(result).isEqualTo(24);
    }

    @Test
    @DisplayName("양수 변경, 문자 목록을 양수 목록으로 변경한다. 문자나 음수 입력시 Exception이 발생한다")
    public void convert_positive_number_문자_and_음수() throws Exception{
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
            calculator.convertPositiveNumbers(Arrays.asList("1a"));
        }).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> {
            calculator.convertPositiveNumbers(Arrays.asList("-1"));
        }).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("양수 변경, 문자 목록을 양수 목록으로 변경한다")
    public void convert_positive_number_양수() {
        Calculator calculator = new Calculator();
        List<Integer> integers = calculator.convertPositiveNumbers(Arrays.asList("1", "2", "3"));
        assertThat(integers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("기본 덧셈 계산기, 더하기 연산자 전달시 문자열을 읽어서 합계를 구한다")
    public void cal_add_default() {
        String text = "1,2,3:4";
        Operator operator = new AddOperator();
        Calculator calculator = new Calculator();
        int result = calculator.cal(text, operator);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 곱셈 계산기, 더하기 연산자 전달시 문자열을 읽어서 합계를 구한다")
    public void cal_multiply_default() {
        String text = "1,2,3:4";
        Operator operator = new MultiplyOperator();
        Calculator calculator = new Calculator();
        int result = calculator.cal(text, operator);
        assertThat(result).isEqualTo(24);
    }

    @Test
    @DisplayName("커스텀 덧셈 계산기, 더하기 연산자 전달시 문자열을 읽어서 합계를 구한다")
    public void cal_add_custom() {
        String text = "//;\n1;2;3;4";
        Operator operator = new AddOperator();
        Calculator calculator = new Calculator();
        int result = calculator.cal(text, operator);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 곱셈 계산기, 더하기 연산자 전달시 문자열을 읽어서 합계를 구한다")
    public void cal_multiply_custom() {
        String text = "//;\n1;2;3;4";
        Operator operator = new MultiplyOperator();
        Calculator calculator = new Calculator();
        int result = calculator.cal(text, operator);
        assertThat(result).isEqualTo(24);
    }

    @Test
    @DisplayName("커스텀 곱셈 계산기, 문자나 음수 전달시 Exception이 발생한다")
    public void cal_multiply_default_문자_and_음수() throws Exception{

        assertThatThrownBy(() -> {
            String text = "a1,2,3:4";
            Operator operator = new MultiplyOperator();
            Calculator calculator = new Calculator();
            int result = calculator.cal(text, operator);
        }).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> {
            String text = "1,-2,3:4";
            Operator operator = new MultiplyOperator();
            Calculator calculator = new Calculator();
            int result = calculator.cal(text, operator);
        }).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("커스텀 곱셈 계산기, 문자나 음수 전달시 Exception이 발생한다")
    public void cal_multiply_custom_문자_and_음수() throws Exception{

        assertThatThrownBy(() -> {
            String text = "//;\n1;2;-3;4";
            Operator operator = new MultiplyOperator();
            Calculator calculator = new Calculator();
            int result = calculator.cal(text, operator);
        }).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> {
            String text = "//;\n1;2;a3;4";
            Operator operator = new MultiplyOperator();
            Calculator calculator = new Calculator();
            int result = calculator.cal(text, operator);
        }).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("양수 변경, 문자 목록을 양수 목록으로 변경한다. 문자나 음수 입력시 Exception이 발생한다")
    public void ㅋㅌㅊㅊㅌㅋ() throws Exception{
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
            calculator.convertPositiveNumbers(Arrays.asList("1a"));
        }).isInstanceOf(Exception.class);

        assertThatThrownBy(() -> {
            calculator.convertPositiveNumbers(Arrays.asList("-1"));
        }).isInstanceOf(Exception.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산기, null 이나 빈문자인 경우 return 0 ")
    public void cal_null_또는_빈문자(String text) {
        Calculator calculator = new Calculator();
        Operator operator = new AddOperator();
        assertThat(calculator.cal(text, operator)).isEqualTo(0);
    }
}