package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리 되는지 확인")
    void commaSeparatedStringWithTwoInputs() {
        // given
        String givenString = "1,2";

        // when
        String[] splitString = givenString.split(",");

        // then
        assertThat(splitString).contains("1", "2");
        assertThat(splitString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환 되는지 확인")
    void commaSeparatedStringWithOneInput() {
        // given
        String givenString = "1";

        // when
        String[] splitString = givenString.split(",");

        // then
        assertThat(splitString).contains("1");
        assertThat(splitString).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 1,2 반환하는지 확인")
    void removeBracketsInString() {
        // given
        String givenString = "(1,2)";

        // when
        String bracketRemovedString = givenString.substring(1, givenString.length() - 1);

        // then
        assertThat(bracketRemovedString).isEqualTo("1,2");
    }
}
