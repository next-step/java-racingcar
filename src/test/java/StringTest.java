import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {


    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지")
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @DisplayName("1을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    @Test
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환")
    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("abc값이 주어졌을 때 String의 charAt()메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    @Test
    void thrownIndexOutOfBoundExceptionWhenOutOfIndexUsingChartAt() {

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(5))
            .withMessageMatching("String index out of range: \\d");
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void chartAt() {
        char a = "abc".charAt(0);
        char b = "abc".charAt(1);
        char c = "abc".charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }


}
