package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest2 {
    @Test
    void empty_or_null() {
        Assertions.assertThat(StringAddCalculator2.splitAndAdd( "")).isEqualTo(0);
    }

    @Test
    void 문자열분리() {
        String input = "1,2";

        Assertions.assertThat(input.split(",")).contains("1", "2");
    }

    @Test
    void 문자열2개() {
        String input = "1,2";
        String[] strNumbers = input.split(",");

        int result = StringAddCalculator2.add(strNumbers);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void 문자열3개() {
        String input = "1,2,3";
        String[] strNumbers = input.split(",");

        Assertions.assertThat(StringAddCalculator2.add(strNumbers)).isEqualTo(6);
    }

    @Test
    void split_쉼표와콜론을처리한다() {
        String input = "1,2:3";
        String[] strNumbers = StringAddCalculator2.split(input);

        Assertions.assertThat(strNumbers).contains("1","2","3");
    }

    @Test
    void 커스텀구분자를추출한다() {
        String input = "//a\n";

        Assertions.assertThat(StringAddCalculator2.extractDelimiter(input)).isEqualTo("a");
    }

    @Test
    void parseInt_숫자이외의문자열은처리할수없다() {
        String input = "zzz";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator2.parseInt(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseInt_음수는처리할수없다() {
        String input = "-1";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator2.parseInt(input);
        }).isInstanceOf(RuntimeException.class);
    }

}
