package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 문자열 사칙 연산 계산기 구현
 * - 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다.
 * - 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.
 */
public class CalculatorTest {

    @DisplayName("입력값이 null인 경우 IllegalArgumentException 처리")
    @Test
    public void 입력값이_null(){
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 빈 공백 문자인 경우 IllegalArgumentException 처리")
    @Test
    public void 입력값이_빈_공백_문자(){
        assertThatThrownBy(() -> {
            Calculator.calculate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비정상적인 입력값인 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(strings = {"1 + ",  "1 + 3 +"})
    public void 비정상적인_입력값(String expression){
        assertThatThrownBy(() -> {
            Calculator.calculate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호 아닌 입력값인 경우 IllegalStateException 처리")
    @Test
    public void 사칙연산_기호_아닌_입력값(){
        assertThatThrownBy(() -> {
            Calculator.calculate("1 ^ 3");
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("분자가 0인 나눗셈")
    @Test
    public void 분자가_0인_나눗셈(){
        assertThat(Calculator.calculate("0 / 10")).isEqualTo(0);
    }

    @DisplayName("분모가 0인 나눗셈인 경우 IllegalArgumentException 처리")
    @Test
    public void 분모가_0인_나눗셈(){
        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청식: {0} | 결과값: {1}")
    @CsvSource(value = {"1 + 2:3", "3 - 2:1", "3 * 2:6", "4 / 2:2"}, delimiter = ':')
    void 사칙연산_정상_확인(String expression, int result) {
        assertThat(Calculator.calculate(expression)).isEqualTo(result);
    }

    @DisplayName("다중 사칙연산 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청식: {0} | 결과값: {1}")
    @CsvSource(value = {"-2 + 3 * 4:4", "2 + 3 * 4:20", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void 다중_사칙연산_정상_확인(String expression, int result) {
        assertThat(Calculator.calculate(expression)).isEqualTo(result);
    }
}
