package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
//    @ParameterizedTest
//    @CsvSource(value = {"1,2:1\",\"2", "1:1"}, delimiter = ':')
    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertAll(
                () -> assertThat(result1).contains("1"),
                () -> assertThat(result1).contains("2"),
                () -> assertThat(result1).containsExactly("1","2"),
                () -> assertThat(result2).containsExactly("1")
        );

    }

    @Test
    void removeBracket() {
        String result = "(1,2)".replaceAll("\\(", "")
                .replaceAll("\\)", "");
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열 범위 내 특정 위치의 문자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    void extractCharacter(int input, char expected) {
        char result = "abc".charAt(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 범위 외 경우 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void extractCharacterOutofRange() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
