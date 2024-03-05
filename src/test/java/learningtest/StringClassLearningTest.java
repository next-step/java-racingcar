package learningtest;

import static org.assertj.core.api.Assertions.*;

import java.text.MessageFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringClassLearningTest {

    // 요구사항 1
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

    @Nested
    @DisplayName("split() 메서드 학습 테스트")
    class Split {

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

    // 요구사항 2
    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

    @Nested
    @DisplayName("substring() 메서드 학습 테스트")
    class Substring {

        @Test
        @DisplayName("문자열 '(1,2)' 소괄호 제거")
        void removeParentheses() {
            String testString = "(1,2)";

            String actual = testString.substring(1, testString.length() - 1);
            assertThat(actual).isEqualTo("1,2");
        }
    }

    // 요구사항 3
    // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

    @Nested
    @DisplayName("charAt() 메서드 학습 테스트")
    class ChatAt {

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
