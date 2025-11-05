package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split이 정상 동작하는지 확인한다.")
    void spilt(){
        String[] data = "1,2".split(",");

        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring이 정상 동작하는지 확인한다.")
    void substring(){
        String data = "(1,2)".substring(0, 4);
        assertThat(data).contains("1,2");
    }

    @Test
    @DisplayName("charAt으로 각 문자열을 정상적으로 조회해온다")
    void shouldSuccessEqualsCharAt(){
        String text = "abc";

        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');
    }

    @Test
    void shouldFailOverRangeCharAt(){
        String text = "abc";
        assertThatThrownBy(() -> text.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
