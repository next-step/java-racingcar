import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 을 통해 특정 위치의 문자를 가져온다.")
    void charAt() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @ParameterizedTest(name = "String.charAt() 은 위치 값을 벗어나면 예외를 던진다.")
    @ValueSource(ints = {-1, 3})
    void charAt_위치를_벗어나면_예외(int index) {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
