package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split1 테스트")
    void split1() {
        final String[] actual = "1,2".split(",");

        // actual contains 1,2
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");

        // actual contains 1
        assertThat(actual).containsExactly("1");
    }

    @Test
    void replace() {

        String actual = "(1,2)".replace("(", "").replace(")", "");

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char actual = "abc".charAt(2);

        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException이 발생")
    void charAt2() {

        String actual = "abc";

        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");

    }

}
