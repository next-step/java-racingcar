import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringClassTest {

    @DisplayName("[요구사항1] 문자열 '1,2'를 ,로 split 했을 때 1과 2로 분리된다")
    @Test
    void successSplit1_1() {
        //given
        String str = "1,2";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).contains("1", "2");
    }

    @DisplayName("[요구사항1] 문자열 '1'를 ,로 split 했을 때 1만을 포함하는 배열이 반환된다")
    @Test
    void successSplit1_2() {
        //given
        String str = "1";

        //when
        String[] actual = str.split(",");

        //then
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("[요구사항2] 문자열 '(1,2)'를 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환한다")
    @Test
    void successSplit2() {
        //given
        String str = "(1,2)";

        //when
        String actual = str.substring(1, str.length() - 1);

        //then
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("[요구사항2] 'abc'에서 charAt(0)을 활용해 1번째 위치의 문자인 a를 반환한다")
    @Test
    void successSplit3_1() {
        //given
        String str = "abc";
        int index = 0;

        //when
        char actual = str.charAt(index);

        //then
        assertThat(actual).isEqualTo('a');
    }

    //java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    @DisplayName("[요구사항2] 'abc' 에서 charAt(10)으로 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    void successSplit3_2() {
        //given
        String str = "abc";
        int index = 10;

        //then
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("[요구사항2] 'abc' 에서 charAt(10)으로 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    void successSplit3_2_2() {
        //given
        String str = "abc";
        int index = 10;

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(index);
            }).withMessageMatching("String index out of range: \\d+");
    }

}