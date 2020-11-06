package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    public void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).containsExactly("1", "2");

        String[] string = "1".split(",");
        assertThat(string).contains("1");
    }

    @Test
    @DisplayName("String 특정 문자 테스트")
    public void stringSubstring() {
        String string = "(1,2)";
        String answer = string.substring(1, string.indexOf(")"));
        System.out.println(answer);
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    public void charAt() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 처리하는 예외 테스트")
    public void stringIndexOutOfBoundsException() {
        String text = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> text.charAt(text.length()))
                .withMessage("String index out of range: %s", text.length());
    }
}
