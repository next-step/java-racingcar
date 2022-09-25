package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항1")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");

    }

    @Test
    @DisplayName("요구사항2")
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    void charAt() {
        assertThatThrownBy(() -> {
            Character result = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }

}
