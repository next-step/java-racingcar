package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 테스트하고 " +
            "\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    void testSplit() {
        String data1 = "1,2";
        String[] result1 = data1.split(",");
        assertThat(result1).containsExactly("1","2");

        String data2 = "1";
        String[] result2 = data2.split(",");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 " +
            "활용해 ()을 제거하고 \"1,2\"를 반환하는지 테스트")
    void testSubstring() {
        String data = "(1,2)";
        String result = data.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 " +
            "활용해 특정 위치의 문자를 가져오는 학습 테스트하고 특정 위치의 문자를 " +
            "가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 " +
            "발생하는 부분에 대한 학습 테스트")
    void testCharAt() {

        assertThatThrownBy(() -> {
            String data = "abc";
            assertThat(data.charAt(0)).isEqualTo('a');
            assertThat(data.charAt(1)).isEqualTo('b');
            assertThat(data.charAt(2)).isEqualTo('c');
            assertThat(data.charAt(3)).isEqualTo('d');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");

    }


}
