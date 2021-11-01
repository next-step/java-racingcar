package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splitOneCommaTwo() {
        String[] split = "1,2".split(",");

        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitOne() {
        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    void testRemoveParentheses() {
        // Given
        String given = "(1,2)";

        // When
        String substring = given.substring(1, given.length() - 1);

        // Then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc가 주어졌을 때 index 3 위치의 문자를 가져오려 하면 StringIndexOutOfBoundsException이 발생한다")
    void testCharAtAbcIndex3ShouldThrowOutOfBoundsException() {
        // Given
        String given = "abc";

        // When & Then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            given.charAt(3);
        });
    }

    @Test
    @DisplayName("abc가 주어졌을 때 index 2 위치의 문자를 가져오면 c를 반환한다")
    void testCharAtAbcIndex2ShouldReturnC() {
        // When
        String given = "abc";

        // When
        char actual = given.charAt(2);

        // Then
        assertThat(actual).isEqualTo('c');
    }
}
