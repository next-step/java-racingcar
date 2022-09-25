package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    @Test
    void empty_or_null() {
        assertThat(StringAddCalculator.splitAndAdd( "")).isEqualTo(0);
    }

    @Test
    void 문자열분리() {
        String input = "1,2";

        assertThat(input.split(",")).contains("1", "2");
    }

    @Test
    void 문자열2개() {
        String input = "1,2";
        String[] strNumbers = input.split(",");

        int result = StringAddCalculator.add(strNumbers);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 문자열3개() {
        String input = "1,2,3";
        String[] strNumbers = input.split(",");

        assertThat(StringAddCalculator.add(strNumbers)).isEqualTo(6);
    }

    @Test
    void split_쉼표와콜론을처리한다() {
        String input = "1,2:3";
        String[] strNumbers = StringAddCalculator.parseInputExpression(input).split();

        assertThat(strNumbers).contains("1","2","3");
    }

    @Test
    void 커스텀구분자를추출한다() {
        String input = "//a\n";

        assertThat(StringAddCalculator.extractDelimiter(input)).isEqualTo("a");
    }

    @Test
    void 커스텀구분자가들어있는경우() {
        String input = "//;\n1;2;3";
        String inputContainsNegative = input + ";-1";

        assertThat(StringAddCalculator.splitAndAdd(input)).isEqualTo(6);
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndAdd(inputContainsNegative);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseInt_숫자이외의문자열은처리할수없다() {
        String input = "zzz";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.parseInt(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseInt_음수는처리할수없다() {
        String input = "-1";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.parseInt(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void hasCustomDelimiter_커스구분자를식별한다() {
        String customDelimiter = "//;\n";
        String input = customDelimiter + "1";

        assertThat(StringAddCalculator.hasCustomDelimiter(input)).isTrue();
    }

    @Test
    void getValidInput_커스텀구분자정의를제거한다() {
        String customDelimiter = "//;\n";
        String input = customDelimiter + "1;2;3";
        assertThat(StringAddCalculator.getValidInput(input)).isEqualTo("1;2;3");
    }
}
