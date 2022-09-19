package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    /*
    String 클래스 학습테스트
     */
    @Test
    @DisplayName("요구사항 1 : split test")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 2 : substring test")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : charAt \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자")
    void charAt() {
        String input = "abc";
        int index = 1;

        String oneChar = String.valueOf(input.charAt(index));
        assertThat(oneChar).isEqualTo("b");
    }

    @Test
    @DisplayName("요구사항 3 : charAt Exception")
    void charAtException() {
        String input = "abc";
        int index = 10;

        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

}
