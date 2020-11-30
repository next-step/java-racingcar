package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * String 클래스에 대한 학습 테스트
 */
class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitTwoValuesTest(String input) {
        // Given
        String delimiter = ",";

        // When
        String[] results = input.split(delimiter);

        // Then
        assertAll(
                () -> assertThat(results).contains("1", "2"),
                () -> assertThat(results).containsExactly("1", "2")
        );
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitOneValueTest(String input) {
        // Given
        String delimiter = ",";

        // When
        String[] results = input.split(delimiter);

        // Then
        assertThat(results).contains(input);
    }

    @DisplayName("\"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void substringTest(String input) {
        // Given
        String expected = "1,2";

        // When
        String result = input.substring(1, input.length() - 1);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0:'a'", "1:'b'", "2:'c'"}, delimiter = ':')
    void chartAtTest(int index, char expected) {
        // Given
        String sample = "abc";

        // When
        char result = sample.charAt(index);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("String의 charAt() 메소드를 사용할 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void charAtOutOfBoundExceptionTest(String input) {
        // Given
        int outOfBoundIndex = input.length();

        // When & Then
        assertThatThrownBy(() -> input.charAt(outOfBoundIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %s", outOfBoundIndex));
    }
}
