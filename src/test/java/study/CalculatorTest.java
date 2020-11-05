package study;


import calculator.Calculator;
import calculator.Operator;
import utils.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void testAddition(){
        assertThat(Operator.Addition.action(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testSubtraction(){
        assertThat(Operator.Subtraction.action(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiplication(){
        assertThat(Operator.Multiplication.action(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivision(){
        assertThat(Operator.Division.action(2, 1)).isEqualTo(2);
    }

    @Test
    @DisplayName("0 으로 나눴을 때 예외처리")
    void testDivisionZero(){
        assertThatIllegalArgumentException().isThrownBy(()-> Operator.Division.action(2, 0));

    }

    @Test
    @DisplayName("입력 값 split 테스트")
    void testSplit(){
        String[] result = StringUtil.split("1 2"," ");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("정규식을 이용한 입력 값 split 테스트")
    void testRegExpressionSplit(){
        String[] result = StringUtil.regexSplit("1-1+2", "[\\+\\-]");
        assertThat(result).containsExactly("1","1","2");
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    @DisplayName("입력 값 검증 테스트")
    void testGetValidExpr(final String in) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.getResult(in))
                .withMessageMatching(Calculator.INPUT_EXCEPTION_MSG);

    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "qwe", "12"})
    @DisplayName("사칙연산 기호 실패 테스트")
    void testFailGetOperator(String in){
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperator(in));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("사칙연산 성공 테스트")
    void testSuccessGetOperator(String in){
        assertThat(Operator.getOperator(in)).isInstanceOf(Operator.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10","1 + 1 * 1 / 1:2", "2+ 3 -5 :0"}, delimiter = ':')
    @DisplayName("결과 테스트")
    void testResult(String in, long out){
        Calculator calculator = new Calculator();
        assertThat(calculator.getResult(in)).isEqualTo(out);
    }
}
