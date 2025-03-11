package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName(value = "요구사항 1 : split test")
    void split(){
        // 요구사항 1-1
        String [] requiredOne = "1,2".split(",");
        assertThat(requiredOne).contains("1", "2");

        // 요구사항 1-2
        String[] requiredOneResult = "1".split(",");
        assertThat(requiredOneResult).containsExactly("1");
    }

    @Test
    @DisplayName(value="요구사항 2 : substring test")
    void substring(){
        // 요구사항 2
        String requiredTwo = "(1,2)";
        String requiredTwoResult = requiredTwo.substring(requiredTwo.indexOf('(') + 1, requiredTwo.lastIndexOf(')'));
        assertThat(requiredTwoResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value="요구사항 3 : exception test")
    void exception(){

        // 요구사항 3-1
        assertThatThrownBy(()->{
            IntStream.range(0, 100).forEach(idx -> "abc".charAt(idx));
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");

        // 요구사항 3-2
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    IntStream.range(0, 100).forEach(idx -> "abc".charAt(idx));
                }).withMessageMatching("String index out of range: \\d");
    }
}
