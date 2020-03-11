package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class StringTest {
    @Order(1)
    @DisplayName("요구사항1 : split 활용하기")
    @Test
    void split() {
        //given, when
        String[] split = "1,2".split(",");

        //then
        assertThat(split).contains("1");
        assertThat(split).contains("2");
        assertThat(split.length).isEqualTo(2);
        assertThat(split).containsExactly("1", "2");
        assertThat(split).containsAnyOf("1");
        assertThat(split).doesNotContain("3");
        assertThat(split).endsWith("1", "2");
    }

    @Order(2)
    @DisplayName("요구사항2 : substring 활용하기")
    @Test
    void substring() {
        //when
        String substring = "(1,2)".substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Order(3)
    @DisplayName("요구사항2 : substring 활용하기 (2)")
    @Test
    void substring2() {
        //when
        String substring = "(1,2,3)".substring(1, 6);

        //then
        assertThat(substring).isEqualTo("1,2,3");
    }

    @Order(4)
    @DisplayName("요구사항3 : charAt 활용하기")
    @Test
    void charAt() {
        //when
        char result1 = "abc".charAt(0);
        char result2 = "abc".charAt(1);
        char result3 = "abc".charAt(2);

        //then
        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @Order(5)
    @DisplayName("요구사항3 : assertThatThrownBy 활용하기")
    @Test
    void charAt2() {
        //when, then
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }

    @Order(6)
    @DisplayName("요구사항3 : assertThatExceptionOfType 활용하기")
    @Test
    void charAt3() {
        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(3);
                }).withMessageContaining("index");
    }
}