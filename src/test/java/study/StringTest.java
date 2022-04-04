package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Nested
    @DisplayName("요구사항 1")
    class 요구사항1 {

        @Test
        @DisplayName("성공 - split이 된다.")
        void test1() {
            String[] result = "1,2".split(",");
            assertThat(result).containsExactly("1", "2");
            assertThat(result.length).isEqualTo(2);
        }

        @Test
        @DisplayName("성공 - 문자열에_분리할_문자가_없어도_배열이_반환된다.")
        void test2() {
            String[] result = "1".split(",");
            assertThat(result).contains("1");
            assertThat(result.length).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("요구사항2")
    class 요구사항2 {

        @Test
        @DisplayName("성공 - Substring_test")
        void test1() {
            String testCase = "(1,2)";
            String result =testCase.substring(1, testCase.length() - 1);
            assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항3")
    class 요구사항3 {

        @Test
        @DisplayName("성공 - ChartAt으로_특정_위치의_문자를_가져온다")
        void test1() {
            String testCase = "abc";

            char result = testCase.charAt(2);

            assertThat(result).isEqualTo('c');
        }

        @Test
        @DisplayName("실패 - CharAt으로_문자열의_범위를_넘긴다")
        void test2() {
            String testCase = "abc";

            assertThatThrownBy(() -> {
                testCase.charAt(3);
            }).isInstanceOf(IndexOutOfBoundsException.class)
              .hasMessageContaining("range: 3");
        }
    }
}
