package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2"); // 순서보장
    }

    @Test
    void 요구사항2() {
        String myString = "(1,2)";
        String expectedResult = "1,2";

        String result = myString.substring(1,4);

        assertThat(result).isEqualTo(expectedResult);
    }
}
