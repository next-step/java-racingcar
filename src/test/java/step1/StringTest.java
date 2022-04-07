package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {

    @Test
    @DisplayName("문자열 1,2 split 시 1과 2 배열 리턴")
    void stringSplitTest1() {
        // given
        String input = "1,2";
        // when
        String[] split = input.split(",");
        // then
        assertThat(split).containsExactly("1", "2");
        assertThat(split).contains("2", "1");
    }

    @Test
    @DisplayName("문자열 1, split 시 1 리턴")
    void stringSplitTest2() {
        assertThat("1,".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) substring 으로 1,2 문자열 리턴")
    void stringSubstringTest() {
        // given
        String input = "(1,2)";
        // when
        String substring = input.substring(1, input.length() - 1);
        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 abc charAt 으로 위치 리턴")
    void stringCharAtTest() {
        // given
        String input = "abc";
        // when
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        // then
        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');
    }
    
    @Test
    @DisplayName("문자열 abc charAt 범위 초과 시 예외 발생")
    void stringCharAtExceptionTest() {
        // given
        String input = "abc";
        // when
        Throwable throwable = catchThrowable(() -> input.charAt(4));
        // then
        assertThat(throwable).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
