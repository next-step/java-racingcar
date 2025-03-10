package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("splitTest")
    class SplitTest {

        @Test
        @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되가?")
        void splitByComma() {
            // given
            var testData = "1,2";
            var splitter = ",";

            // when
            var result = testData.split(splitter);

            // then
            Assertions.assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("\"1,2\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는가?")
        void splitByCommaWithOne() {
            // given
            var testData = "1,2";
            var splitter = ",";

            // when
            var result = testData.split(splitter);

            // then
            Assertions.assertThat(result).contains("1");
        }
    }

    @Nested
    @DisplayName("substringTest")
    class SubstringTest {

        @Test
        @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring()으로 맨앞뒤를 자르면 \"1,2\"가 반환되는가?")
        void removeParentheses() {
            // given
            var testData = "(1,2)";

            // when
            var result = testData.substring(1, testData.length() - 1);

            // then
            Assertions.assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("charAtTest")
    class CharAtTest {

        @Test
        @DisplayName("\"abc\" 값이 주어졌을 때 charAt()으로 특정 위치의 문자를 가져오는가?")
        void getCharAt() {
            // given
            var testData = "abc";
            var index = 1;

            // when
            var result = testData.charAt(index);

            // then
            Assertions.assertThat(result).isEqualTo('b');
        }

        @Test
        @DisplayName("charAt()으로 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는가?")
        void getCharAtWithIndexOutOfBounds() {
            // given
            var testData = "abc";
            var index = testData.length();

            // when & then
            Assertions.assertThatThrownBy(() -> testData.charAt(index))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessage("String index out of range: " + index);
        }
    }
}
