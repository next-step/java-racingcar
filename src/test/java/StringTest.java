import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

    @DisplayName("문자열 \"1,2\"에 대해 spiit()을 활용해 \"1\", \"2\"를 반환할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitByComma_MultipleValues(String text) {
        assertThat(text.split(",")).containsExactly("1", "2");
    }

    @DisplayName("문자열 \"1\"에 대해 spiit()을 활용해 \"1\"을 반환할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitByComma_SingleValue(String text) {
        assertThat(text.split(",")).containsExactly("1");
    }

    @DisplayName("문자열 \"(1,2)\"에 대해 substring()을 활용해 괄호를 제거할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void removeParentheses_UsingSubstring(String text) {
        assertThat(text.substring(1, 4)).isEqualTo("1,2");
    }

    @DisplayName("문자열 \"abc\"에 대해 charAt()을 활용해 특정 위치의 문자(b)를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void getCharacter_UsingCharAt(String text) {
        assertThat(text.charAt(1)).isEqualTo('b');
    }

    @DisplayName("문자열 \"abc\"에 charAt()을 사용해 범위를 벗어난 위치를 조회하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void charAt_OutOfBounds_ThrowsException(String text) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> text.charAt(3));
    }
}
