package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring()
    {
        String input = "//;\n1;2;3";
        String result1  = input.substring(4);
        assertThat(result1).isEqualTo("1;2;3");
    }
    @Test
    @DisplayName("올바른 위치의 문자를 가져옴")
    void charAtValid()
    {
        String input = "abc";
        int idx = 1;
        char result = input.charAt(idx);

        assertEquals('b', result);
    }

    @Test
    @DisplayName("위치 값을 벗어나면 예외 발생")
    void charAtInvalid()
    {
        String input = "abc";
        int invalidIdx = 10;
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            char result = input.charAt(invalidIdx);
        });
    }
    @Test
    @DisplayName("콤마 문자열 파싱")
    void split콤마() {
        String input = "1,2,3";
        String[] tokens = input.split(",");
        assertThat(tokens).containsExactly("1", "2", "3");
    }
    @Test
    @DisplayName("콜론 문자열 파싱")
    void split콜론() {
        String input = "1:2:3";
        String[] tokens = input.split(":");
        assertThat(tokens).containsExactly("1", "2", "3");
    }
    @Test
    @DisplayName("콤마 혹은 콜론 문자열 파싱")
    void split콤마_콜론() {
        String input = "1,2:3";
        String[] tokens = input.split(",|:");
        assertThat(tokens).containsExactly("1", "2", "3");
    }
    @Test
    @DisplayName("음수가 포함된 경우 문자열 파싱을 확인")
    void split음수_포함() {
        String input = "-1,2,3";
        String[] tokens = input.split(",");
        assertThat(tokens).containsExactly("-1", "2", "3");
    }
    @Test
    void splitCustomDelim() {
        String input = "//;\n1;2;3";
        String text  = input.substring(4);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()){
            assertThat(m.group(1)).isEqualTo(";");
        }
    }
    @Test
    void contains() {
        String customStr1 = "//";
        String customStr2 = "\n";
        String input = "//;\n1;2;3";
        if (input.contains(customStr1) && input.contains(customStr2)){
            input = input.substring(4);
            assertThat(input).isEqualTo("1;2;3");
        } else{
            assertThat(input).isEqualTo(input);
        }
    }
}