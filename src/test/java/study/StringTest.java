package study;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("특정 위치의 문자를 가져오는지 확인")
    void charAtTest() {
        // given
        final String givenString = "abc";

        // when
        char index0FromGivenString = givenString.charAt(0);
        char index1FromGivenString = givenString.charAt(1);
        char index2FromGivenString = givenString.charAt(2);

        // then
        assertThat(index0FromGivenString).isEqualTo('a');
        assertThat(index1FromGivenString).isEqualTo('b');
        assertThat(index2FromGivenString).isEqualTo('c');
    }

    @Test
    @DisplayName("위치값이 벗어났을 경우 IndexOutOfBoundsException 예외 발생")
    void stringIndexOutOfBoundsExceptionTest() {
        // given
        String givenString = "abc";

        // when
        ThrowingCallable thrown = () -> givenString.charAt(givenString.length());

        // then
        assertThatThrownBy(thrown)
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
