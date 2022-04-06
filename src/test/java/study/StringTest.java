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
        @DisplayName("성공 - 문자열에 분리할 문자가 없어도 배열이 반환된다.")
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
        @DisplayName("성공 -  start 인덱스부터 end 전 인덱스까지 문자열을 자른다.")
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
        @DisplayName("성공 - ChartAt으로 특정위치의 문자를 가져온다")
        void test1() {
            String testCase = "abc";

            char result = testCase.charAt(2);

            assertThat(result).isEqualTo('c');
        }

        @Test
        @DisplayName("실패 - CharAt으로 문자열의 범위를 넘긴다")
        void test2() {
            String testCase = "abc";

            assertThatThrownBy(() -> {
                testCase.charAt(3);
            }).isInstanceOf(IndexOutOfBoundsException.class)
              .hasMessageContaining("range: 3");
        }
    }
}
