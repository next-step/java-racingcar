package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("should split number when multiple parameter exist")
    void testSplit_multipleParam() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("should split number when single parameter exist")
    void testSplit_singleParam() {
        String input = "1,";
        assertThat(input.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("should substring input")
    void testSubString() {
        String input = "(1,2)";
        assertThat(input.substring(1, 4)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("should get character of specified index")
    void testCharAt_normalCond(int index, char target) {
        String input = "abc";
        assertThat(input.charAt(index)).isEqualTo(target);
    }

    @Test
    @DisplayName("should throw exception when index out of range")
    void testCharAt_exceptionCond() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}