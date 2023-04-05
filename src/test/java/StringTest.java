import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 요구사항2() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스 범위 초과 에러")
    void 요구사항3() {
        assertThatThrownBy(() -> {
            int index = 4;
            String text = "abc";
            text.charAt(index);

        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    int index = 5;
                    String text = "abc";
                    text.charAt(index);
                }).withMessageMatching("String index out of range: \\d");

    }

}
