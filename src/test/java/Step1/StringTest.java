package Step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 요구사항2() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드를 사용해 특정 위치문자를 가져온다. 위치 값을 벗어나면 StringIndexOutOfBoundsException를 발생한다.")
    void 요구사항3() {
        String result = "abc";
        char a = result.charAt(0);
        assertThat(a).isEqualTo('a');

        assertThatThrownBy(() -> {
            result.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    result.charAt(10);
                }).withMessageMatching("String index out of range: 10");
    }
}
