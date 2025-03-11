package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리된다.")
    public void splitStringWithComma() {
        String input = "1,2";
        String[] actual = input.split(",");
        String[] expected = new String[]{"1", "2"};

        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    public void splitSingleStringWithComma() {
        String input = "1";
        String[] actual = input.split(",");
        String[] expected = new String[]{"1"};

        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
    public void removeBracketsFromString() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length()-1);
        String expected = "1,2";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    public void getCharAtIndex() {
        String input = "abc";
        char actual = input.charAt(0);
        char expected = 'a';

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    public void charAtOutOfRange_ThrowsException() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}
