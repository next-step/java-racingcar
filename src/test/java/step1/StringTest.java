package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).contains("1");
    }


    @Test
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }


    @DisplayName("charAt()으로 특정 위치의 문자를 가져온다.")
    @ParameterizedTest
    @CsvSource(value={"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt(int input, char expected) {
        assertEquals("abc".charAt(input), expected);
    }


    @DisplayName("charAt() 인덱스가 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
