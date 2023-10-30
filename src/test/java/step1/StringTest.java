package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Nested
    @DisplayName("요구사항1. split테스트")
    class splitTest {
        @DisplayName("문자열 1,2 구분자로 분리")
        @Test
        public void splitMultipleString() {
            String splitTest = "1,2";
            String[] splitTestList = splitTest.split(",");
            assertThat(splitTestList).contains("1", "2");
        }

        @DisplayName("단일문자 1 구분자로 분리")
        @Test
        public void splitSingleString() {
            String splitTest = "1";
            String[] splitTestList = splitTest.split(",");
            assertThat(splitTestList).containsExactly("1");
        }
    }

    @DisplayName("()괄호제거")
    @Test
    public void subString() {
        String subTest = "(1,2)";
        String subResult = subTest.substring(1, subTest.length() - 1);
        assertThat(subResult).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("요구사항3. 문자추출")
    class charAtTest {
        @DisplayName("b문자 추출")
        @Test
        public void stringCharAtTest() {
            String charAtTest = "abc";
            char result = charAtTest.charAt(1);
            assertThat(result).isEqualTo('b');
        }

        @DisplayName("문자열 길이를 벗어난 추출로 에러")
        @Test
        public void StringIndexOutOfBoundsExceptionTest() {
            String charAtTest = "abc";
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> charAtTest.charAt(4)).withMessageMatching("String index out of range: \\d+");
        }
    }
}
