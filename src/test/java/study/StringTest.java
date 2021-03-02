package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1. 1,2를 split했을 때 잘 분리되는지")
    void split() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2. 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환")
    void splitReturnOne() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("요구사항 2. substring() 의 메소드를 활용해 ()을 제거하고 1,2만 반환")
    void removeBracket() {
        String data = "(1,2)";
        String result = data.substring(data.indexOf("("), data.indexOf(")"));
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3. charAt() 메소드를 활용해 특정 위치의 문자를 반환 및 StringIndexOutOfBoundsException 테스트")
    void getChar() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(3);
                }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("Index: 2, Size: 2");
    }
}
