package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    @DisplayName("split()으로 문자열에서 배열 변환이 잘 되는지 확인한다.")
    void split(){
        assertThat("1,2".split(",")).contains("1");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring()으로 ()를 제거하고 1,2가 반환되는지 확인한다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 활용해 특정 위치 문자를 가져올 때, StringIndexOutOfBoundsException이 발생하는 경우를 확인한다.")
    void charAtIndexOutOfBoundsException(){
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(-1);
        }).withMessageMatching("String index out of range: -\\d+");
    }
}
