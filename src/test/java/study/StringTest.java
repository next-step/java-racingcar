package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스 테스트")
public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 호출 시 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void returnOfIndexOutOfBoundsExceptionOnCallCharAt() {
        assertThatThrownBy(() -> {
            String input = "test";
            input.charAt(input.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
