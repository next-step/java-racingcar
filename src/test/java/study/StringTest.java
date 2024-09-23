package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void testStringSplitByDelimiter() {
        String parameter = "1,2";
        String delimiter = ",";

        String[] result = parameter.split(delimiter);

        assertThat(result).contains("1", "2");
    }

    @Test
    public void testStringSplitByDelimiterWithSingleElement() {
        String parameter = "1";
        String delimiter = ",";

        String[] result = parameter.split(delimiter);

        assertThat(result).containsExactly("1");
    }

    @Test
    public void testExtractStringInParentheses() {
        String parameter = "(1,2)";

        String result = parameter.substring(1, parameter.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void testGetCharAt() {
        String parameter = "abc";
        int index = 0;

        char result = parameter.charAt(index);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열의 범위를 벗어난 index 를 사용할 경우 예외가 발생한다.")
    public void testGetCharAtWithIndexOutOfRange() {

        assertThatThrownBy(() -> {
            String parameter = "abc";
            int index = -1;
            parameter.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }
}
