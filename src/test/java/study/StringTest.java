package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {
    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

    }

    @Test
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");

    }

    @Test
    void subStringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chartAt 메소드에서 위치값을 벗어나면 발생하는 예외 테스트")
    void charAtTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

