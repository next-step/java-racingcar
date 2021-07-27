package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitTest1() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String[] split = "1".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substring(){
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt Normal test")
    void charAtTest1(){
        char firstCharacter = "abc".charAt(0);
        assertThat(firstCharacter).isEqualTo('a');
    }

    @Test
    @DisplayName("throw exception StringIndexOutOfBound")
    void charAtTest2(){
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("throw exception StringIndexOutOfBound")
    void charAtTest3(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}