package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항1 - split 활용")
    void splitTest() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1,2".split(",")).containsExactly("1","2");

        assertThat("1".split(",")).contains("1");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - substring 활용")
    void substringTest() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - charAt 활용")
    void charAtTest() {
        char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항3 - charAt 활용해 특정 위치 값을 벗어날 때 Exception 발생  (ThrownBy)")
    void charAtExceptionTestV1() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }

    @Test
    @DisplayName("요구사항3 - charAt 활용해 특정 위치 값을 벗어날 때 Exception 발생 (ExceptionOfType)")
    void charAtExceptionTestV2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: [0-9]*");
    }

}
