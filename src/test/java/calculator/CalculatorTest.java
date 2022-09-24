package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 공백_또는_null() {
        String value = "";
        int result = Calculator.sum(value);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        String value = "1";
        int result = Calculator.sum(value);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표_분리() {
        String value = "1,2";
        int[] numbers = Calculator.split(value);
        assertThat(numbers).contains(1,2);
        assertThat(Calculator.sum(value)).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_분리() {
        String value = "1,2:3";
        int[] numbers = Calculator.split(value);
        assertThat(numbers).contains(1,2,3);
        assertThat(Calculator.sum(value)).isEqualTo(6);
    }

    @Test
    void 음수일때() {
        String value = "-1,2:3";
        assertThatThrownBy(() -> {
            Calculator.sum(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_이외의_값_일때() {
        String value = "a,2:3";
        assertThatThrownBy(() -> {
            Calculator.sum(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀구분자() {
        String value = "//;\n1;2;3";
        assertThat(Calculator.sum(value)).isEqualTo(6);
    }
}


