package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용한 특정 위치의 문자를 가져온다.")
    void charAt() {
        String input = "abc";
        char result = input.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_throws_StringIndexOutOfBoundsException_ifIndexIsInvalid() {
        String input = "abc";
        assertThatThrownBy(() -> {input.charAt(3);})
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
