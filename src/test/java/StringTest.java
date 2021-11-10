import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String Class 들의 Method 들을 테스트하는 코드")
public class StringTest {

    @DisplayName("String 요구사항 1-1. split 기본 기능 테스트")
    @Test
    void splitTest1() {
        String str = "1,2";
        String[] split = str.split(",");

        assertThat(split).contains("1");
        assertThat(split).contains("2");
    }

    @DisplayName("String 요구사항 1-2. ,가 없을 경우 테스트")
    @Test
    void splitTest2() {
        String str = "1";
        String[] split = str.split(",");

        assertThat(split).containsExactly("1");
    }

    @DisplayName("String 추가 테스트. 순서 유지 테스트")
    @Test
    void splitOrderTest() {
        String str = "1,2,3";
        String[] split = str.split(",");

        assertThat(split).containsExactly("1", "2", "3");
    }

    @DisplayName("String 요구사항 2. substring 기능 테스트")
    @Test
    void substringTest() {
        String str = "(1,2)";
        String substr = str.substring(1, 4);

        assertThat(substr).isEqualTo("1,2");
    }

    @DisplayName("String 요구사항 3-1. charAt 기능 테스트")
    @Test
    void charAtTest() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isNotEqualTo('b');
    }

    @DisplayName("String 요구사항 3-2. charAt exception 테스트")
    @Test
    void charAtExceptionTest() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("e");
    }
}