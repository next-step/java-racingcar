package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_test() {
        String str = "1,2";
        String[] strArr = str.split(",");

        assertThat(strArr).containsExactly("1", "2");
    }

    @Test
    void substring_test() {
        String str = "(1,2)";
        String str2 = str.substring(1, 4);

        System.out.println(str2);
    }

    @Test
    @DisplayName("특정 위치의 문자를 반환_하는 테스트")
    void find_character_test() {
        String str = "abc";

        char a = str.charAt(0);
        char b = str.charAt(1);
        char c = str.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("존재_하지 않는 위치의 문자를 가져올 때 IndexOutOfBoundsException 발생 시키는 테스트")
    void index_out_of_bounds_test() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
