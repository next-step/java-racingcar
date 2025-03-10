import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * 요구사항 1
 * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
 * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
 * 힌트
 * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
 * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
 * 요구사항 2
 * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
 * 요구사항 3
 * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
 * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
 * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
 */

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
}
