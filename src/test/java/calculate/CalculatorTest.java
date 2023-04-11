package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest { // Operand

    @Test
    @DisplayName("구분자 기준으로 숫자 배열 나누기")
    void hasDelimiter() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);
        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("커스텀 구분자 포함여부")
    void hasCustomDelimiter() {

        String input1 = "₩₩.\n1:2:3";

        assertThat(input1.substring(0, 2)).contains("₩₩");
        assertThat(input1.substring(3, 4)).contains("\n");

        Matcher m = Pattern.compile("₩₩(.)\n(.*)").matcher(input1);
        assertThat(m.find()).isTrue();
        assertThat(Calculator.hasCustomDelimiter(input1)).isTrue(); // "₩₩.\n" 매핑되는지
    }

    @Test
    @DisplayName("일반 구분자 추출하기")
    void 일반_구분자() {

        String input1 = "1,2,3";
        String delimiter = Calculator.extractGeneralDelimiter(input1);

        assertThat(Calculator.hasCustomDelimiter(input1)).isFalse();
        assertThat(input1).isEqualTo("1,2,3");
        assertThat(delimiter).isEqualTo(",");
    }

    @Test
    @DisplayName("커스텀 구분자 가져오기")
    void getCustomDelimiter() {

        String input = "₩₩.\n";
        String delimiter = Calculator.extractCustomDelimiter(input);

        assertThat(Calculator.hasCustomDelimiter(input)).isTrue();
        assertThat(delimiter).isEqualTo(".");
    }

    @Test
    @DisplayName("널 또는 빈문자열")
    void isNull() {
        String input1 = "";
        String input2 = null;

        assertThat(input1).isEqualTo("");
        assertThat(input2).isEqualTo(null);

        assertThat(Calculator.isNullOrEmpty(input1)).isTrue();
        assertThat(Calculator.isNullOrEmpty(input2)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자에서 구분자와 피연산자 추출")
    void extractInputNumbersAndDelimiter() {

        String input = "₩₩;\n1;2;3";
        String delimiter = Calculator.extractCustomDelimiter(input);
        String inputNumbers = input.substring(4);

        assertThat(delimiter).isEqualTo(";");
        assertThat(inputNumbers).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("커스텀 구분자에서 숫자배열 추출")
    void extractNumbers() {

        String input = "₩₩;\n1;2;3";
        String delimiter = Calculator.extractCustomDelimiter(input);
        String inputNumbers = input.substring(4);

        assertThat(Calculator.extractNumbers(inputNumbers, delimiter))
                .isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    @DisplayName("음수 포함한다면 RuntimeException")
    void hasNegative() {

        String input = "1,-2,3";
        String delimiter = ",";
        String[] stringPart = input.split(delimiter);

        assertThatThrownBy(() -> Calculator.hasOnlyPositive(stringPart))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("알파벳 포함한다면 RuntimeException")
    void hasChar() {

        String input = "1,2,3,A,5";
        String delimiter = ",";
        String[] stringPart = input.split(delimiter);

        assertThatThrownBy(() -> Calculator.hasOnlyPositive(stringPart))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 배열 입력 숫자 합 리턴")
    void sumOfNumbers() {

        int[] numbers = {1, 2, 3};
        int resultOfSum = Calculator.sumOfNumbers(numbers);

        assertThat(resultOfSum).isEqualTo(6);
    }
}
