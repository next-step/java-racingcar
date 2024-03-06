package learningtest;

import static org.assertj.core.api.Assertions.*;

import java.text.MessageFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringClassLearningTest {

    @Nested
    @DisplayName("split() 메서드 학습 테스트")
    class SplitTest {

        @Test
        @DisplayName("문자열 '1,2' 분리")
        void splitOneCommaTwoString() {
            String testString = "1,2";
            String[] actual = testString.split(",");

            assertThat(actual).hasSize(2);
            assertThat(actual).containsExactly("1", "2"); // if the order does matter

        }

        @Test
        @DisplayName("단일 문자열 분리")
        void splitSingleString() {
            String testString = "1";
            String[] actual = testString.split(",");

            assertThat(actual).hasSize(1);
            assertThat(actual).containsOnly("1");
        }

    }

    @Nested
    @DisplayName("substring() 메서드 학습 테스트")
    class SubstringTest {

        @Test
        @DisplayName("문자열 '(1,2)' 소괄호 제거")
        void removeParentheses() {
            String testString = "(1,2)";

            String actual = testString.substring(1, testString.length() - 1);
            assertThat(actual).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("charAt() 메서드 학습 테스트")
    class ChatAtTest {

        @Test
        @DisplayName("[성공] 문자열 'a,b,c' 에서 2번째 위치의 문자 가져오기")
        void getTwiceCharFromABCString() {
            String testString = "a,b,c";
            char actual = testString.charAt(2);

            assertThat(actual).isEqualTo('b');
        }

        @Test
        @DisplayName("[실패] 인덱스 == 문자열 길이, 문자열 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
        void charAtOutOfIndex() {
            String testString = "a,b,c";
            int index = testString.length();

            assertThatStringIndexOutOfBoundsException(testString, index);
        }

        @Test
        @DisplayName("[실패] 인덱스 == -1, 인덱스 범위를 넘어선 문자를 가져올 경우 StringIndexOutOfBoundsException 발생")
        void chatAtMinusIndex() {
            String testString = "a,b,c";
            int index = -1;

            assertThatStringIndexOutOfBoundsException(testString, index);
        }
    }

    private void assertThatStringIndexOutOfBoundsException(String testString, int index) {
        assertThatThrownBy(() -> {
            testString.charAt(index);
        })
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage(MessageFormat.format("String index out of range: {0}", index));
    }
}
