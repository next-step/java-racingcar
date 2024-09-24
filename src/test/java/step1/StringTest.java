package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리되어야 한다.")
    void requirement_1_1() {
        String[] given = "1,2".split(",");
        assertThat(given).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되어야 한다.")
    void requirement_1_2() {
        String[] given = "1".split(",");
        assertThat(given).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring() 으로 \"(\", \")\"을 제거하고 \"1,2\"를 반환한다")
    void requirement_2_1() {
        String given = "(1,2)".substring(1, 4);
        assertThat(given).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt() 으로 특정 위치의 문자를 가져온다.")
    void requirement_3_1(int index, char expected) {
        assertThat("abc".charAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("chatAt() 호출 시 문자의 범위를 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void requirement_3_2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> "abc".charAt(999));
    }
}
