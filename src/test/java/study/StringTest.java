package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split() 동작 테스트")
    void splitString() {
        String input = "1,2";

        String[] expected = input.split(",");

        assertThat(expected)
                .containsExactly("1", "2")
                .contains("1")
                .contains("2");
    }

    @Test
    @DisplayName("Substring() 동작 테스트")
    void subString() {
        String input = "(1,2)";
        int beginIndex = 1;
        int lastIndex = input.length() - 1;

        String expected = input.substring(beginIndex, lastIndex);

        assertThat(expected)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("올바른 인덱싱에서의 charAt() 동작 테스트")
    void charAtWithValidIndex() {
        String input = "abc";
        Character[] results = {'a', 'b', 'c'};

        for (int i = 0; i < input.length(); i++) {
            Character expected = input.charAt(i);
            assertThat(expected)
                    .isEqualTo(results[i]);
        }

    }

    @Test
    @DisplayName("올바르지 않은 인덱싱에서의 charAt() 동작 테스트")
    void charAtWithInvalidIndex() {
        String input = "abc";
        int invalidSmallIndex = -1;
        int invalidBigIndex = input.length();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(
                        () -> {
                            input.charAt(invalidSmallIndex);
                        }
                );

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(
                        () -> {
                            input.charAt(invalidBigIndex);
                        }
                );
    }
}
