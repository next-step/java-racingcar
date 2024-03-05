package learningtest;

import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Step1 - String 클래스에 대한 학습테스트")
public class StringClassTest {
    @Nested
    @DisplayName("split 테스트")
    class SplitTest {
        @Test
        @DisplayName("구분자를 기준으로 분리된 배열을 반환한다")
        void testSplitDelimiter() {
            String[] result = "1,2".split(",");

            assertThat(result).contains("1", "2");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("구분자가 존재하지 않으면 단일 배열값을 반환한다")
        void testSplitSingle() {
            String[] result = "1".split(",");

            assertThat(result).contains("1");
            assertThat(result).containsExactly("1");
        }
    }

    @Test
    @DisplayName("지정한 인덱스의 부분 문자열만 반환한다")
    void testSubString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("charAt 테스트")
    class CharAtTest {
        String input = "abc";
        int lastIndex = input.length() - 1;

        @Test
        @DisplayName("문자열의 특정 위치의 문자를 반환한다")
        void testCharAt() {
            char result = input.charAt(lastIndex);

            assertThat(result).isEqualTo('c');
        }

        @Test
        @DisplayName("문자열의 인덱스 범위를 벗어난 경우 예외가 발생한다")
        void testCharAtFail_Index() {
            assertThatThrownBy(() -> input.charAt(lastIndex + 100))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
