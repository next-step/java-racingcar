package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "1 - 1:0", "2 * 2:4", "4 / 2:2"}, delimiter = ':')
    @DisplayName("이항 사칙연산을 수행하면 결과값이 정상적으로 리턴된다.")
    void 이항연산(String input, Double expected) {
        Double result = StringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 + 1:3", "1 * 2 * 3 * 4:24", "8 / 2 / 2 / 2:1", "3 * 4 - 1 * 2:22"}, delimiter = ':')
    @DisplayName("다항 사칙연산을 수행하면 결과값이 정상적으로 리턴된다.")
    void 다항연산(String input, Double expected) {
        Double result = StringCalculator.calculate(input);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("input이 null일 때 IllegalArgumentException을 발생시킨다.")
    void nullTest(String input){
        assertThatThrownBy(() -> StringCalculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input이 empty일 때 IllegalArgumentException을 발생시킨다.")
    void emptyInputTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(""));
        assertThatThrownBy(() -> StringCalculator.calculate("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 계산식 - 숫자포맷파싱불가일 경우 NumberFormatException을 발생시킨다.")
    void wrongExpression(){
        assertThatThrownBy(() -> StringCalculator.calculate("1-=2")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("잘못된 연산자일 경우 IllegalArgumentException을 발생시킨다..")
    void wrongOperator(){
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("1 % 2"));
    }
}
