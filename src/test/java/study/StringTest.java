package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {

    @DisplayName("`1,2`를 ,로 split 했을 때 1과 2로 잘 분리되는지")
    @Test
    void splitLearningTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("`1`을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    @Test
    void splitLearningTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("`(1,2)`을 substring 메서드를 활용해 괄호를 잘 제거할 수 있는지")
    @Test
    void substringLearningTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("`abc`를 charAt() 메서드를 활용해 특정 위치의 문자를 잘 가져올 수 있는지")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtLearningTest1(int index, char expected) {
        String data = "abc";
        assertThat(data.charAt(index)).isEqualTo(expected);
    }

    @DisplayName("charAt() 메서드가 문자열의 범위를 벗어난 위치의 문자를 가져올 때 StringIndexOutOfBoundsException을 반환하는지")
    @Test
    void charAtLearningTest2() {
        String data = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(4));
    }
}
