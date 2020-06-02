package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    //  요구사항 1
    @DisplayName("콤마 split 테스트")
    @Test
    void commaSplit() {
        String[] input = "1,2".split(",");
        assertThat(input).contains("1").containsExactly("1", "2");
    }

    //  요구사항 2
    @DisplayName("괄호 제거 테스트")
    @Test
    void removeBracket() {
        String data = "(1,2)";
        String result = data.substring(data.indexOf("(") + 1, data.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    //  요구사항 3
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    @Test
    void stringInRange() {
        String input = "abc";
        int index = 5;
        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("Index: %d, Size: %d", index, input.length());
    }

}
