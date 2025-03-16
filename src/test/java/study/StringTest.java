package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("쉼표(,)로 구분된 숫자 문자열을 분리하면 각 숫자가 개별 요소로 반환된다.")
    public void splitStringWithComma() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("하나의 숫자 문자열을 쉼표(,)로 분리하면 원본 숫자 문자열 그대로 반환된다.")
    public void splitSingleStringWithComma() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("괄호가 포함된 문자열에서 앞뒤 괄호를 제거하면 내부 문자열만 남는다.")
    public void removeBracketsFromString() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length()-1);
        String expected = "1,2";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("문자열에서 charAt(index)를 사용하면 해당 위치의 문자를 반환한다.")
    public void getCharAtIndex() {
        String input = "abc";
        char actual = input.charAt(0);
        char expected = 'a';

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("charAt(index) 사용 시 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    public void charAtOutOfRange_ThrowsException() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}
