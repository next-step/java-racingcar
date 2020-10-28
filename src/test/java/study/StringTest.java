package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String Split Test")
    void split() {
        String inputStr = "1,2";

        String[] result = inputStr.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("괄호 삭제 테스트")
    void removeBraketTest() {

        String inputStr = "(1,2)";

        String result = inputStr.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }
}
