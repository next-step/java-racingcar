package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("요구사항 1 : 1,2 ,로 split 했을 때 1과 2로 잘 분리되는지 확")
    @Test
    void split_1_and_2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1 : 1을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
    @Test
    void split_1() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("요구사항 2 : (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거한 후 1,2 리")
    @Test
    void substring_return_1_and_2() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 : abc 값이 주어졌을 때 String의 charAt() 활룡하여 특정 위치 문자를 리턴")
    @Test
    void charAt_get_certain_word() {
        char data = "abc".charAt(2);
        assertThat(data).isEqualTo('c');
    }

    @DisplayName("charAt() 특정범위를 벗어날 경우")
    @Test
    void StringIndexOutOfBoundsExceptionTest() {

        assertThatThrownBy(() -> {
            char data = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}