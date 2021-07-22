package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringClassTest {

    @DisplayName("콤마(,)로 분리한 문자가 모두 배열에 저장되어야 한다.")
    @Test
    void TEST_split_1(){
        String str = "1,2";
        String[] arr = str.split(",");

        assertThat(arr).contains("1","2");
    }

    @DisplayName("분리할 문자가 없어도 한개의 값이 배열에 저장되어야 한다.")
    @Test
    void TEST_split_2(){
        String str = "1";
        String[] arr = str.split(",");

        assertThat(arr).containsExactly("1");
    }

    @DisplayName("주어진 문자열에서 ()을 제거하여 반환해야한다.")
    @Test
    void TEST_substring(){
        String str = "(1,2)";
        String result = str.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져와야한다.")
    @Test
    void TEST_charAt_1(){
        String str = "abc";
        char result = str.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @DisplayName("인덱스를 벗어나면 에러가 발생해야한다.")
    @Test
    void TEST_charAt_2(){
        String str = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
