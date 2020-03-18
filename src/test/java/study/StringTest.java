package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @DisplayName("요구사항 1")
    @Test
    public void string_test() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        String[] numberOne = "1".split(",");
        assertThat(numberOne).contains("1");
    }

    @DisplayName("요구사항 2")
    @Test
    public void eliminate_brace_test() {
        //given
        String source = "(1,2)";
        //when
        String result = source.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 : 범위를 벗어난 인덱스를 호출하면 예외를 발생시킨다")
    @Test
    public void chatAt_test() {
        //given
        String source = "abc";

        //when & then
        assertThatThrownBy(() -> {
            source.charAt(-1);
        })
        .isInstanceOf(IndexOutOfBoundsException.class);
    }


}
