package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split2() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1로 분리되는지 확인")
    void split1() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result)
                .containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    void substring() {
        // given
        String input = "(1, 2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result)
                .isEqualTo("1, 2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 0번 위치의 문자를 가져온다")
    void charAt(int index, char expected) {
        // given
        String input = "abc";

        // when
        char result = input.charAt(index);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("String의 charAt() 메소드를 활용 시 범위를 벗어나면 Exception 발생")
    void charAt_outOfBound(int index) {
        // given
        String input = "abc";

        // then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    // when
                    input.charAt(index);
                })
                .withMessageContaining("String index out of range: " + index);
    }
}
