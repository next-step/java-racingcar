package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest { // Operand

    @Test
    @DisplayName("구분자 기준으로 숫자 배열 나누기")
    void hasDelimiter() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);

        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
//        assertThat(input.contains("4")).isEqualTo(false);
        for (String s : numbers) {
            System.out.println(parseInt(s));
        }
    }

    @Test
    @DisplayName("커스텀 구분자 포함여부")
    void hasCustomDelimiter() {

        String input1 = "₩₩.\n1:2:3";
        String input2 = "₩₩.\n";
        String input3 = "₩.\n";
        // 길이 3 이상인지
        assertThat(input2.length()).isGreaterThan(3);
        // "₩₩.\n" 매핑되는지
        assertThat(input1.substring(0, 2)).contains("₩₩");
        assertThat(input2.substring(3, 4)).contains("\n");
        // 위의 조건 만족 시 3번째 문자 리턴
        assertThat(input2.substring(2, 3)).contains(".");
        Matcher m = Pattern.compile("₩₩(.)\n(.*)").matcher(input1);
        Matcher m2 = Pattern.compile("₩₩(.)\n(.*)").matcher(input2);
        Matcher m3 = Pattern.compile("₩₩(.)\n(.*)").matcher(input3);

        assertThat(m.find()).isTrue();
        assertThat(m2.find()).isTrue();
        assertThat(m3.find()).isFalse();

        Calculator c = new Calculator();
        assertThat(c.hasCustomDelimiter(input2)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 포함된 경우")
    void 커스텀_구분자() {

        String input1 = "₩₩.\n1.2.3";
        String delimiter = ",|:";
        String numbersInput = "";

        Calculator c = new Calculator();
        assertThat(c.hasCustomDelimiter(input1)).isTrue();

        if (c.hasCustomDelimiter(input1)) {
            delimiter = c.getCustomDelimiter(input1);
            numbersInput = input1.substring(4);
        }

        assertThat(numbersInput).isEqualTo("1.2.3");
        assertThat(delimiter).isEqualTo(".");
    }

    @Test
    @DisplayName("일반 구분자")
    void 일반_구분자() {

        String input1 = "1,2,3";
        String delimiter = ",|:";
        String numbersInput = "";

        Calculator c = new Calculator();
        assertThat(c.hasCustomDelimiter(input1)).isFalse();

        numbersInput = input1;
        String[] numbers = numbersInput.split(delimiter);

        delimiter = c.getGeneralDelimiter(input1);

        for (String s : numbers) {
            System.out.println(parseInt(s));
        }

        assertThat(numbersInput).isEqualTo("1,2,3");
        assertThat(delimiter).isEqualTo(",");
    }

    @Test
    @DisplayName("커스텀 구분자 가져오기")
    void getCustomDelimiter() {

        String input =  "₩₩.\n";
        String delimiter = "";

        Calculator c = new Calculator();

        if (c.hasCustomDelimiter(input)) {
            delimiter = c.getCustomDelimiter(input);
        }
        System.out.println(delimiter);
    }

    @Test
    @DisplayName("음수_전달할경우_Exception")
    void negative() throws Exception {

        int[] numbers = {1,-2, 3};
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                assertThat(numbers[i]).isNegative();
                //throw new Exception("is negative");
            } else {
                assertThat(numbers[i]).isNotNegative();
            }
        }
        assertThat(numbers.length).isEqualTo(3);
    }

    @Test
    @DisplayName("널_또는_빈문자열")
    void isNull() {
        String input1 = "";
        String input2 = null;
        String input3 = "null";
        // 길이 3 이상인지
        assertThat(input1).isEqualTo("");
        assertThat(input2).isEqualTo(null);

        Calculator c = new Calculator();
        assertThat(c.isNullOrEmpty(input1)).isTrue();
        assertThat(c.isNullOrEmpty(input2)).isTrue();
        assertThat(c.isNullOrEmpty(input3)).isFalse();

        if (c.isNullOrEmpty(input1)) {
            System.out.println("0");
        }
    }
    @Test
    @DisplayName("구분자로 나누기")
    void splitWithDelimiter() {

        String input =  "₩₩.\n1.2.3";
        String delimiter = ",|:";
        String inputNumbers ="";

        Calculator c = new Calculator();

        inputNumbers = input;

        if (c.hasCustomDelimiter(input)) {
            delimiter = c.getCustomDelimiter(input);
            inputNumbers = input.substring(4);
        }

        assertThat(delimiter).isEqualTo(".");
        assertThat(inputNumbers).isEqualTo("1.2.3");

        int[] numbers =c.getNumbers(inputNumbers, delimiter);
    }

    @Test
    @DisplayName("음수 포함 ")
    void hasNegative() {

        String input =  "1,-2,3";
        String delimiter = ",";

        Calculator c = new Calculator();

        String[] stringPart = input.split(delimiter);
        boolean result = c.hasOnlyNumber(stringPart);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("알파벳 포함")
    void hasChar() {

        String input =  "1,2,3,A,5";
        String delimiter = ",";

        Calculator c = new Calculator();

        String[] stringPart = input.split(delimiter);
        boolean result = c.hasOnlyNumber(stringPart);

        assertThat(result).isFalse();
    }
}
