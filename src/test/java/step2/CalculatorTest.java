package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final static Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 테스트")
    public void add () {
        assertThat(calculator.addition(3, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("빼기 테스트")
    public void sub () {
        assertThat(calculator.subtraction(3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    public void mul () {
        assertThat(calculator.multiplication(3, 2)).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void div () {
        assertThat(calculator.division(2,1)).isEqualTo(2);
    }

    @DisplayName("문자열이 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void vaildate (String data) {
        assertThrows(IllegalArgumentException.class, () -> calculator.vaildate(data));
    }

    @DisplayName("공백의 문자열 분리")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void sp(String data){
        assertThat(calculator.sp(data)).contains("2","3","4","2","+","*","/");
    }
}
