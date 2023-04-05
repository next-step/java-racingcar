package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @DisplayName("1단계_StringTest_요구사항1 - split() 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split_n개() {
        //given
        String testData = "1,2";

        //when
        String[] result = testData.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1단계_StringTest_요구사항1 - split() 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split_1개() {
        //given
        String testData = "1";

        //when
        String[] result = testData.split(",");

        //then
        assertThat(result).containsExactly("1");
    }

    @DisplayName("1단계_StringTest_요구사항2 - substring() 했을 때 1,2 반환되는지 확인")
    @Test
    void substring() {
        //given
        String testData = "(1,2)";

        //when
        String result = testData.substring(1, testData.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");

    }

    @DisplayName("1단계_StringTest_요구사항3 - charAt() 했을 때 abc 특정 위치의 문자가 반환되는지 확인")
    @Test
    void charAt() {
        //given
        String testData = "abc";

        //when, then
        assertThat(testData.charAt(0)).isEqualTo('a');
        assertThat(testData.charAt(1)).isEqualTo('b');
        assertThat(testData.charAt(2)).isEqualTo('c');
    }

    @DisplayName("1단계_StringTest_요구사항3 - charAt() 했을 때 abc 특정 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생되는지 확인")
    @Test
    void charAt_outOfIndex() {
        //given
        String testData = "abc";

        //when, then
        assertThatThrownBy(() -> {
                    testData.charAt(testData.length());
                })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + testData.length());
    }
}
