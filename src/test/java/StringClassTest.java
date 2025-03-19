import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringClassTest {

    @DisplayName("[요구사항1] 문자열 '1,2'를 ,로 split 했을 때 1과 2로 분리된다")
    @Test
    void successSplit1_1() {
        String str = "1,2";

        String[] actual = str.split(",");

        assertThat(actual).contains("1", "2");
    }

    @DisplayName("[요구사항1] 문자열 '1'를 ,로 split 했을 때 1만을 포함하는 배열이 반환된다")
    @Test
    void successSplit1_2() {
        String str = "1";

        String[] actual = str.split(",");

        assertThat(actual).containsExactly("1");
    }

    @DisplayName("[요구사항2] 문자열 '(1,2)'를 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환한다")
    @Test
    void successSplit2() {
        String str = "(1,2)";

        String actual = str.substring(1, str.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("[요구사항2] 'abc'에서 charAt(0)을 활용해 1번째 위치의 문자인 a를 반환한다")
    @Test
    void successSplit3_1() {
        String str = "abc";
        int index = 0;

        char actual = str.charAt(index);

        assertThat(actual).isEqualTo('a');
    }

    //java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    @DisplayName("[요구사항2] 'abc' 에서 charAt(10)으로 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    void successSplit3_2() {
        String str = "abc";
        int index = 10;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("[요구사항2] 'abc' 에서 charAt(10)으로 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    void successSplit3_2_2() {
        String str = "abc";
        int index = 10;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(index);
            }).withMessageMatching("String index out of range: \\d+");
    }

}