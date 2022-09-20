package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("\"1,2\"을 ','로 split 했을 때, \"1\"과 \"2\"로 분리되어야 한다.")
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ','로 split 했을 때, \"1\"만 포함하는 배열을 반환해야 한다.")
    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때, 양 끝 문자를 제거하면 \"1,2\"를 반환해야 한다.")
    @Test
    void substring() {
        String data = "(1,2)";
        String actual = data.substring(1, data.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 문자열이 주어졌을 때, 각 인덱스에 해당하는 문자를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,a,",
            "1,b",
            "2,c"
    })
    void charAt(int index, char expected) {
        char actual = "abc".charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("\"abc\" 문자열이 주어졌을 때, 문자열의 인덱스를 벗어나면 StringIndexOutOfBoundsException이 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void charAt_givenOutOfIndex(int index) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(index));
    }

}
