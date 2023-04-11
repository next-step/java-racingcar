package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("구분자 기준으로 숫자 배열 나누기")
    void hasDelimiter() {

        String delimiter = ",|:";
        String input = "1,2:3";
        String[] numbers = input.split(delimiter);
        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("커스텀 구분자 포함여부")
    void hasCustomDelimiter() {

        String input1 = "₩₩;\n1;2;3";

        assertThat(input1.substring(0, 2)).contains("₩₩");
        assertThat(input1.substring(3, 4)).contains("\n");

        Matcher m = Pattern.compile("₩₩(;)\n(.*)").matcher(input1);
        assertThat(m.find()).isTrue();
    }

    @Test
    @DisplayName("구분자 기준으로 숫자 배열 나누기")
    void operandCreate() {

    }

    @Test
    @DisplayName("커스텀 구분자에서 구분자와 피연산자 추출")
    void extractInputNumbersAndDelimiter() {

        String input = "₩₩;\n1;2;3";
        String delimiter = StringAddCalculator.extractCustomDelimiter(input);
        String inputNumbers = input.substring(4);

        assertThat(delimiter).isEqualTo(";");
        assertThat(inputNumbers).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("커스텀 구분자에서 숫자배열 추출")
    void extractNumbers() {

        Operand operand = new Operand("₩₩;\n1;2;3");
        assertThatThrownBy(() -> StringAddCalculator.hasOnlyPositive(operand))
                .isInstanceOf(RuntimeException.class);

        StringAddCalculator.extractDelimiter(operand);

        assertThat(StringAddCalculator.extractNumbers(operand).numbers)
                .isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    @DisplayName("음수 포함한다면 RuntimeException")
    void hasNegative() {
        Operand operand = new Operand("1,-2,3");
        assertThatThrownBy(() -> StringAddCalculator.hasOnlyPositive(operand))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("알파벳 포함한다면 RuntimeException")
    void hasChar() {
        Operand operand = new Operand("1,2,3,A,5");
        assertThatThrownBy(() -> StringAddCalculator.hasOnlyPositive(operand))
                .isInstanceOf(RuntimeException.class);
    }
}
