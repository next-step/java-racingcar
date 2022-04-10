package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).contains("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt 테스트")
    void charAtTest(int index, char expectedChar) {
        assertThat("abc".charAt(index)).isEqualTo(expectedChar);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    @DisplayName("charAt 테스트 실패 케이스")
    void charAtTestFail(int index) {
        assertThatThrownBy(() -> "abc".charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
