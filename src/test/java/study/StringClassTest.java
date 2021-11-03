package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringClassTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitTwoValuesTest(String input) {
        // given
        String delimiter = ",";
        // when
        String[] results = input.split(delimiter);
        // then
        assertThat(results).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitOneValueTest(String input) {
        // given
        String delimiter = ",";
        // when
        String[] results = input.split(delimiter);
        // then
        assertThat(results).containsExactly(input);
    }

    @DisplayName("\"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void substringTest(String input) {
        // when
        String result = input.substring(1, input.length() - 1);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0:'a'", "1:'b'", "2:'c'"}, delimiter = ':')
    void chartAtTest(int index, char expected) {
        // given
        String sample = "abc";
        // when
        char result = sample.charAt(index);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("String의 charAt() 메소드를 사용할 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void charAtOutOfBoundExceptionTest(String input) {
        // given
        int outOfBoundIndex = input.length();
        // when & then
        assertThatThrownBy(() -> input.charAt(outOfBoundIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %s", outOfBoundIndex));
    }
}
