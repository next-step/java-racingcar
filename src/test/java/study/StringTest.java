package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split  테스트")
    void split(){
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");

        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring  테스트")
    void substring(){
        String result = "(1,2)";
        result = result.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자의 index에 존재하는 문자확인")
    public void charAt() {
        String result = "abc";
        char compareValue = result.charAt(0);
        assertThat(compareValue).isEqualTo('a');

        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}
