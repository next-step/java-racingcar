package studytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

    @DisplayName("split()을 활용해 구분자가 있는 문자열을 분리할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitByComma_MultipleValues(String text) {
        assertThat(text.split(",")).containsExactly("1", "2");
    }

    @DisplayName("spit() 결과 구분자가 없는 문자열은 그대로 반환된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitByComma_SingleValue(String text) {
        assertThat(text.split(",")).containsExactly("1");
    }

    @DisplayName("substring()을 활용해 문자열에서 필요한 부분을 얻을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void removeParentheses_UsingSubstring(String text) {
        assertThat(text.substring(1, 4)).isEqualTo("1,2");
    }

    @DisplayName("chatAt()을 활용해 문자열에서 특정 위치의 문자를 얻을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void getCharacter_UsingCharAt(String text) {
        assertThat(text.charAt(1)).isEqualTo('b');
    }

    @DisplayName("문자열의 범위를 벗어난 위치에 대해 chatAt()을 사용하면 예외가 발생한다..")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void charAt_OutOfBounds_ThrowsException(String text) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> text.charAt(3));
    }
}
