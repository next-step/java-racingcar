package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("요구사항1:문자열 분리 테스트 - 쉼표로 문자열 1,2 분리 검증")
    void splitComma() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1:문자열 분리 테스트 - 문자열 1을 쉼표로 분리 시, 정상 반환 여부 검증")
    void splitContain() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2:특정 문자열 반환 테스트")
    void findStringFromString() {
        String input = "(1,2)";
        String result = input.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3:특정 위치의 문자 획득 테스트")
    void findCharFromString() {
        String input = "abc";
        char result = input.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항3: 예외 테스트 - 문자열의 인덱스를 벗어날 경우(StringIndexOutOfBoundsException)")
    void findCharFromStringException() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
