import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 한글_length() {
        assertAll(
            () -> assertThat("세글자".length()).isEqualTo(3),
            () -> assertThat("세글자".getBytes(StandardCharsets.UTF_8).length).isEqualTo(3 * 3)
        );
    }

    @Test
    @DisplayName("2개 이상 요소 split 정상 테스트")
    void splitMultipleElementsTest() {
        // given
        String input = "1,2";

        // when
        String[] splitInputs = input.split(",");

        // then
        assertThat(splitInputs).contains("1").contains("2");
    }

    @Test
    @DisplayName("1개 요소 split 정상 테스트")
    void splitSingleElementTest() {
        // given
        String input = "1,";

        // when
        String[] splitInputs = input.split(",");

        // then
        assertThat(splitInputs).containsOnly("1");
    }

    @Test
    @DisplayName("substring 정상 테스트")
    void substringTest() {
        // given
        String input = "(1,2)";

        // when
        String output = input.substring(1, input.length() - 1);

        // then
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 정상 테스트")
    void charAtTest() {
        // given
        String input = "abc";

        // when
        char output = input.charAt(0);

        // then
        assertThat(output).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt 인덱스 범위 초과 exception 테스트")
    void charAtStringIndexOutOfBoundsExceptionTest() {
        // given
        String input = "abc";

        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(input.length())
            ).withMessageMatching("String index out of range: \\d+");
    }
}
