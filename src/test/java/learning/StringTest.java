package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("String 요구사항 1 : , 를 기준으로 분리하여 반환")
    void stringSplit() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 요구사항 1 : , 으로 분리 했을때 1만 포함하는 배열 반환")
    void stringListSplit() {
        String[] result = "1,".split(",");
        assertThat(result).containsExactly("1");
    }


    @Test
    @DisplayName("String 요구사항 2 : () 제거하고 1,2 반환")
    void subString() {
        String str = "(1,2)";
        String result = str.substring(0, str.length() - 1);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("String 요구사항 3 : 특정 위치 문자를 가져 옴")
    void stringCharAt() {
        String str = "abc";
        char result = str.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("String 요구사항 3 : 특정 위치 문자를 가져올때 값을 벗어나면 exception 발생")
    void stringCharAtException() {
        String str = "abc";
        assertThatThrownBy(() ->
                str.charAt(2)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index: 2, Size: 2");
    }

}
