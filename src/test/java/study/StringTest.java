package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void split3() {
        final String actual = "(1,2)".replace("(", "").replace(")", "");
        System.out.println(actual);
    }

    @Test
    @DisplayName("임의의 문자열에서 특정 문자 가져오기")
    void getSpecificString() {
        assertThatThrownBy(() -> {
            // ...
            final String input = "abc";
            final int index = input.indexOf("d");
            final String found = input.substring(index, index + 1);
            System.out.println(found);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
