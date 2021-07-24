package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("잘못된 범위의 index로 charAt 실행시 에러 테스트")
    void chatAt() {
        // given
        String input = "abc";

        // when
        Throwable throwable = catchThrowable(() -> input.charAt(input.length()));

        // then
        assertThat(throwable).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
