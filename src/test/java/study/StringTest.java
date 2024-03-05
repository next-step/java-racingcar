package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void testSplitManyNumberWithComma() {
        String[] testData = "1,2".split(",");
        assertThat(testData).containsExactly("1","2");
    }

    @Test
    void testSplitSingleNumberWithComma() {
        String[] testData ="1".split(",");
        assertThat(testData).containsExactly("1");
    }

    @Test
    void testRemoveBracketInManyNumber() {
        String testData = "(1,2)";
        String resultData = testData.substring(1, testData.length()-1);

        assertThat(resultData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt(index) 를 이용할 때 정상 범위일 경우, 해당 문자 반환")
    void testStringCharAtValidIndex() {
        String testData = "abc";
        int lastIndex = testData.length() -1;

        assertThat(testData.charAt(lastIndex)).isEqualTo('c');
    }

    @Test
    @DisplayName("String charAt(index) 를 이용할 때 범위를 벗어나면, StringIndexOutOfBoundsException 발생")
    void testStringCharAtInvalidIndex() {
        String testData = "abc";

        assertThatThrownBy(() -> testData.charAt(testData.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
