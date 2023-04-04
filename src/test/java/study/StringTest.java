package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        //순서보장확인
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인수가 벗어난 값을 호출했을 때 항상 실패한다")
    void chartAt() {
        //given
        String input = "abc";
        //when
        Throwable thrown = catchThrowable(() -> {
            input.charAt(4);
        });
        // then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
