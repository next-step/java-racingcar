import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringLearningTest {

    @Test
    void validateFeature1() {
        String[] givenMultipleElementArray = "1,2".split(",");
        String[] givenOneElementArray = "1".split(",");

        Assertions.assertThat(givenMultipleElementArray).containsExactly("1", "2");
        Assertions.assertThat(givenOneElementArray).containsExactly("1");
    }

    @Test
    void validateFeature2() {
        String givenRawString = "(1,2)";

        String leftBracketRemovedString = removeLeftBracket(givenRawString);
        String rightBracketRemovedString = removeRightBracket(leftBracketRemovedString);

        Assertions.assertThat(rightBracketRemovedString).isEqualTo("1,2");
    }

    private String removeLeftBracket(String input) {
        return input.substring(1, input.length());
    }

    private String removeRightBracket(String input) {
        return input.substring(0, input.length()-1);
    }

    @DisplayName("String.charAt()에서 index를 벗어나면 StringIndexOutOfBoundsException 발생한다")
    @Test
    void validateFeature3() {
        String givenString = "abc";

        Assertions.assertThat(givenString.charAt(0)).isEqualTo('a');

        Assertions.assertThatThrownBy(() -> {
            givenString.charAt(givenString.length() * 2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
