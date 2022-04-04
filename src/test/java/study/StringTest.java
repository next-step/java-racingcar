package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        final String DELIMETER = ",";

        String[] result1 = "1,2".split(DELIMETER);
        String[] result2 = "1".split(DELIMETER);

        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest() {
        String input = "(1,2)";

        String result = input.substring(1, input.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 성공 테스트")
    void charAtTest() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String 범위를 벗어난 인덱스로 chatAt 요청시 예외 발생 테스트")
    void charAtFailTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).hasMessageContaining("String index out of range: 3");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,3})
    @DisplayName("charAt 예외시 assertThatExceptionOfType으로 예외 발생 감지 테스트")
    void charAtFailTest(int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(index);
                }).withMessageMatching("String index out of range: [-]?[0-9]+");
    }
}
