package step1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("특정 문자로 문자열을 분리해서 배열에 담는 split method test")
    void split() {
        String[] result_1 = "1".split(",");
        assertThat(result_1).containsExactly("1");
        String[] result_2 = "1,2".split(",");
        assertThat(result_2).containsExactly("1", "2");
    }

    @Test
    @DisplayName("원하는 문자열만 뽑아내는 substring method test")
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1,str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() method test")
    void charAt() {
        Character result = "0123456".charAt(1);
        assertThat(result).isEqualTo('1');
    }
    @Test
    @DisplayName("charAt()의 인덱스가 문자열을 벗어날때 exception 발생 test")
    void stringIndexOutOfBoundsException(){
        assertThatThrownBy(() -> {
            Character result = "0123456".charAt(11);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}