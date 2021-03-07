package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value={"2 + 3:5","2 - 3:-1","2 * 3:6","4 / 2:2"},delimiter = ':')
    @DisplayName("사칙연산 테스트, +,-,*,/ 통합 테스트")
    void 사칙연산(String input,String expected){
        assertThat(Calculator.calcuate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 모두 포함된 경우 테스트")
    void stringCalculate(){
        String input = "2 + 3 * 4 / 2 - 30";
        assertThat(Calculator.calcuate(input)).isEqualTo(-20);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""," "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 테스트")
    void returnIllegalArgumentExceptionIfNullOrEmpty(String input){
        assertTrue(StringValidator.isBlank(input));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 테스트, IllegalArgumentException 발생할 경우 테스트 통과")
    void isFourArithmeticOperations(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            Operations.findSymbol("+");
            Operations.findSymbol("-");
            Operations.findSymbol("*");
            Operations.findSymbol("/");
            Operations.findSymbol("%");
        });
    }
}
