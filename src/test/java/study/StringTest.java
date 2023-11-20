package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    public static String ABC = "abc";

    @Test
    @DisplayName("구분자 제거")
    public void split1(String word) {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }


    @ParameterizedTest
    @DisplayName("특정 문자열 (괄호) 제거")
    @CsvSource(value = {"(1,2):1,2"}, delimiter = ':')
    public void split2(String input, String expected) {
        assertThat(removeParentheses(input)).isEqualTo(expected);
    }

    private String removeParentheses(String input) {
        // 첫 번째 문자부터 마지막 전 문자까지의 부분 문자열을 추출
        return input.substring(1, input.length() - 1);
    }

    @Test
    @DisplayName("제한 위치 외 문자열 검색 에러")
    public void split3() {

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            char result = ABC.charAt(5);
        });
    }

}
