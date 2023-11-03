package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_구분자_여러개() {
        String[] result = "1,2:3".split(",|\\:");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void split_regex() {
        String input = "//;::\n1;::2";
        String[] result = input.split("//|\n");
        assertThat(result[1]).isEqualTo(";::");
        Assertions.assertTrue(input.matches("//\\D+\n.*"));
    }

    @Test
    void regex_match와group() {
        String text = "//&\n1&2";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            assertThat(m.group(0)).isEqualTo(text);
            assertThat(m.group(1)).isEqualTo("&");
            assertThat(m.group(2)).isEqualTo("1&2");
        }
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt(성공) - String의 index내로 CharAt으로 특정위치의 문자를 가져온다")
    void charAtSuccess() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt(실패) - String의 index범위밖으로 CharAt을 사용하면 StringIndexOutOfBoundsException를 throw한다.")
    void charAtFail() {
        assertThatThrownBy(() -> "abc".charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}
