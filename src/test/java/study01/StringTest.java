package study01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - split()으로 구분 문자를 기준으로 문자열 분리")
    void splitTest01_commaSplitCase() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 - split()으로 구분 문자가 없는 문자열 분리")
    void splitTest02_commaNotSplitCase() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - substring()으로 부분 문자열 얻기")
    void substringTest01() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - charAt()으로 특정 위치의 캐릭터 추출")
    void charAtTest01() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()));
    }
}
