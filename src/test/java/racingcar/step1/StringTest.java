package racingcar.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2 를 분리한다")
    void splitTestStep1() {
        final String [] result = "1,2".split(",");
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 1만을 포함하는 배열을 반환한다")
    void splitTestStep2() {
        final String [] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값 ()을 제거하고 \"1,2\"를 반환 한다")
    void substringTest() {
        final String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 배열 범위를 벗어난 index 시 예외를 발생한다.")
    void strWithIndexOutOfBoundsTest() {
        final String testInitValue = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> testInitValue.charAt(testInitValue.length()))
                .withMessageContaining("index out of range")
                .withMessageMatching("String index out of range: \\d+");
    }

}
