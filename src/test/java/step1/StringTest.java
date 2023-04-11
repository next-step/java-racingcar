package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 했을 때 1과 2로 잘 분리되는지, 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void splitTest() {
        // given
        String containComma = "1,2";
        String notContainComma = "1";

        // when
        String[] containCommaSplit = containComma.split(",");
        String[] notContainCommaSplit = notContainComma.split(",");

        // then
        assertThat(containCommaSplit).containsExactly("1", "2");
        assertThat(notContainCommaSplit).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는 테스트")
    void substringTest() {
        // given
        String originalStr = "(1,2)";

        // when
        String result = originalStr.substring(1, originalStr.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAtTest(int number, char string) {
        // given
        String originalStr = "abc";
        // when & then
        assertThat(originalStr.charAt(number)).isEqualTo(string);
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우 학습 테스트")
    void charAtTestWithStringIndexOut() {
        // given
        String originalStr = "abc";

        // when & then
        assertThatThrownBy(
                () -> originalStr.charAt(originalStr.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + originalStr.length());
    }
}
