package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열 체크")
    void empty(){
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("null 체크")
    void checkNull() {
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 , 체크")
    void comma() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 : 체크")
    void colon() {
        assertThat(splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("음수 체크")
    void negative(){
        assertThatThrownBy(()-> { splitAndSum("-1:2,3"); }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값 체크")
    void nonNumber() {
        assertThatThrownBy(()-> { splitAndSum("a:b:2"); }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "커스텀 구분자 체크 {index}")
    @CsvSource(value = {"'//;\n1;2;3':6", "'//#\n1#3#4':8", "'//@\n2@4@5':11"}, delimiter = ':')
    void customDelimiter(String text, int result) {
        assertThat(splitAndSum(text)).isEqualTo(result);
    }

}
