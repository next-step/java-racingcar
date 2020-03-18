package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("split() 메서드 테스트를 성공 한다.")
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1", "2");

        String[] value = "1".split(",");
        assertThat(value).containsExactly("1");

    }

    @DisplayName("substring() 메소드 테스트를 성공 한다.")
    @Test
    void substring() {
        String actual = "(1,2)".substring(1);
        assertThat(actual).isEqualTo("1,2)");

        actual = actual.substring(0, actual.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메서드 테스트시 예외 발생을 성공 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void charAt(int index) {
        final String source = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                source.charAt(index);
            }
        );
    }
}
