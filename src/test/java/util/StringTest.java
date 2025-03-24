package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("요구사항1: \"1,2\"을 ,로 split 하면 1과 2로 분리된다")
    void split() {
        final String str = "1,2";
        final String division = ",";
        String[] strArr = str.split(division);
        assertThat(strArr).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1: \"1\"을 ,로 split 하면 1만을 포함하는 배열이 반환된다")
    void split2() {
        final String str = "1";
        final String division = ",";
        String[] strArr = str.split(division);

        assertThat(strArr)
                .containsOnly("1")
                .containsExactly("1"); //순서까지 일치해야함
    }

    @Test
    @DisplayName("요구사항2: \"(1,2)\" 값이 주어졌을 때, substring() 메소드를 활용해 ()을 제거하면 \"1,2\"를 반환한다.")
    void substring() {
        final String str = "(1,2)";
        String subStr = str.substring(str.indexOf("(")+1, str.indexOf(")"));
        assertThat(subStr).isEqualTo("1,2");
    }

    //참고: https://assertj.github.io/doc/#assertj-core-exception-assertions
    @Test
    @DisplayName("요구사항3: \"abc\" 값이 주어졌을 때, charAt() 메소드를 활용해 특정 위치의 문자를 가져온다. 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt(){
        final String str="abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3))
                .withMessageMatching("String index out of range: \\d+");

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + str.length());
    }


}
