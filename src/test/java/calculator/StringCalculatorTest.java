package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열 체크")
    void empty(){
        StringCalculator calculator = new StringCalculator("");
        assertThat(calculator.splitAndSum()).isEqualTo(0);
    }

    @Test
    @DisplayName("null 체크")
    void checkNull() {
        StringCalculator calculator = new StringCalculator(null);
        assertThat(calculator.splitAndSum()).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 , 체크")
    void comma() {
        StringCalculator calculator = new StringCalculator("1,2");
        assertThat(calculator.splitAndSum()).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 : 체크")
    void colon() {
        StringCalculator calculator = new StringCalculator("1:2");
        assertThat(calculator.splitAndSum()).isEqualTo(3);
    }

    @Test
    @DisplayName("음수 체크")
    void negative(){
        StringCalculator calculator = new StringCalculator("-1:2,3");
        assertThatThrownBy(()-> { calculator.splitAndSum(); }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값 체크")
    void nonNumber() {
        StringCalculator calculator = new StringCalculator("a:b:2");
        assertThatThrownBy(()-> { calculator.splitAndSum(); }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "커스텀 구분자 체크 {index}")
    @CsvSource(value = {"'//;\n1;2;3':6", "'//#\n1#3#4':8", "'//@\n2@4@5':11"}, delimiter = ':')
    void customDelimiter(String text, int result) {
        StringCalculator calculator = new StringCalculator(text);
        assertThat(calculator.splitAndSum()).isEqualTo(result);
    }

}
