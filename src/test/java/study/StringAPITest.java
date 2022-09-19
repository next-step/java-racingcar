package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAPITest {

    @Nested
    @DisplayName("요구사항 1")
    class FirstRequirements {

        @Test
        @DisplayName("split 기능 테스트")
        void checkSplitOfString() {
            String[] givenStrArray = "1,2".split(",");

            assertThat(givenStrArray).containsExactly("1", "2");
            assertThat(givenStrArray).contains("1");
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class SecondRequirements {

        @Test
        @DisplayName("SubString 기능으로 괄호 제거 테스트")
        void removeParenthesisUsingSubString() {
            String givenStr = "(1,2)";

            int indexOfLeftParenthesis = givenStr.indexOf("(");
            int indexOfRightParenthesis = givenStr.indexOf(")");

            String result = givenStr.substring(indexOfLeftParenthesis + 1, indexOfRightParenthesis);

            assertThat(result).contains("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class ThirdRequirements {

        private String givenStr = "sampleString"; // length 12

        @Test
        @DisplayName("CharAt 기능 테스트")
        void checkChatAtOfString() {
            int notOutOfIndex = 10;

            assertThatCode(() -> {
                givenStr.charAt(notOutOfIndex);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("CharAt IndexOutOfBoundsException 테스트")
        void throwIndexOutOfBoundsExceptionFromCharAtOfString() {
            int outOfIndex = 12;

            assertThatThrownBy(() -> {
                givenStr.charAt(outOfIndex);
            })
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 12");
        }
    }
}
