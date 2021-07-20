package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void splitTest() {
        //요구사항1
        //when
        String[] splitOne = "1,2".split(",");
        String[] splitTwo = "1".split(",");
        //then
        assertThat(splitOne).contains("1", "2");
        assertThat(splitTwo).containsExactly("1");
    }

    @Test
    public void subStringTest() {
        //요구사항2
        //when
        String subStringResult = "(1,2)".substring(1,4);
        //then
        assertThat(subStringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 위치반환 테스트")
    public void chatAtTest() {
        //요구사항3
        //when
        Character outputChar = "abc".charAt(0);
        //then
        assertThat(outputChar).isEqualTo('a');
    }

    @Test
    @DisplayName("IndexOutOfBoundException 테스트")
    public void indexOUtOfBoundExceptionTest() {
        //요구사항3
        assertThatThrownBy(() -> {
            //when
            "abc".charAt(3);
            //then
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }
}
