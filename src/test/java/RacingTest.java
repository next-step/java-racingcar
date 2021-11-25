import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingTest {

    @Test
    @DisplayName("요구사항 1-1 : \"1,2\"를 \",\"로 split")
    void req1_sub1() {
        final String input = "1,2";
        final String[] split = input.split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2 : \"1\"을 \",\"로 split 시 1만 반환하는 배열이 반환되는지 확인")
    void req1_sub2() {
        final String input = "1";
        final String delimiter = ",";
        final String[] split = input.split(delimiter);
        assertThat(split).containsOnly(input);
    }

    @Test
    @DisplayName("요구사항 2 : \"(1,2)\"을 substring 메소드로 ()을 제거하고 \"1,2\"만 반환도록 구현")
    void req2() {
        final String input = "(1,2)";
        final String substring = input.substring(1, input.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void req3() {
        final String input = "abc";
        final int invalidIndex = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(invalidIndex))
            .withMessageMatching("String index out of range: " + invalidIndex);
    }
}
