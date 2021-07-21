package study.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.Calculator;
import racing_car.Validation;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private Calculator calculator;
    private Validation validation;
    @BeforeEach
    void init() {
        calculator = new Calculator();
        validation = new Validation();
    }
    @Test
    @DisplayName("사칙연산 결과 테스트")
    public void resultTest() {
        String str = "2 + 10 * 3 / 6";
        int answer = calculator.execute(str.split(" "));
        assertThat(answer).isEqualTo(6);
    }
    @Test
    @DisplayName("입력 값이 null이거나 빈 문자열 일때 예외 처리 테스트")
    public void inputNull() {
        assertThatThrownBy(()-> validation.nullCheck("")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("숫자와 사칙연산 자리에 공백이나 null값이 올 때 예외 처리 테스트")
    public void splitNullCheck(){
        assertThatThrownBy(()-> validation.splitNullCheck("5 +  4 * 3".split(" "))).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("사칙 연산 기호가 아닌 경우 예외 처리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"*:true","^:false","+:true","&:false","/:true","-:true"},delimiter = ':')
    public void arithmeticSymbols(String operator , boolean check){
        Assertions.assertThat(validation.arithmeticSymbolsCheck(operator)).isEqualTo(check);
    }
}