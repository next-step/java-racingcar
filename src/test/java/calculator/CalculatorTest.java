package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 분리, null 이나 빈문자인 경우 return 0 ")
    public void split_null_또는_빈문자(String text) {
        Calculator calculator = new Calculator();
        assertThat(calculator.cal(text)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 분리, 숫자 하나만 있는 경우 하나만 리턴")
    public void split_숫자하나() {
        String text = "1";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        assertThat(delimiter.parse(text)).containsExactly(text);
    }

    @Test
    @DisplayName("문자열 분리, 쉼표를 구분자로 숫자를 분리한다")
    public void split_쉼표구분자() {
        String text = "1,2";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        assertThat(delimiter.parse(text)).containsExactly("1","2");
    }
    @Test
    @DisplayName("문자열 분리, 커스텀 구분자로 숫자를 분리한다")
    public void split_custom_구분자()  {
        String text = "//;\n1;2;3";
        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        assertThat(delimiter.parse(text)).containsExactly("1", "2", "3");
    }
}