package study.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void testSplit() {
        String example1 = "1,2";
        String[] result1 = example1.split(",");
        assertThat(result1).containsExactly("1","2");

        String example2 = "1";
        String[] result2 = example2.split(",");
        assertThat(result2).contains("1");
    }

    @Test
    public void testSubString() {
        String example = "(1,2)";
        String result = example.substring(1, example.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 테스트")
    public void testChatAt() {
        String example = "abc";
        assertThatThrownBy(() -> {
            example.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
