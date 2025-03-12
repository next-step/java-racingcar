package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    @DisplayName("split() Test")
    void split() {
        // 1. "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현
        String[] result1 = "1,2".split(",");
        assertThat(result1).contains("1", "2");

        // 2. "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현
        String[] result2 = "1,".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("substring() Test")
    void substring() {
        // 3. "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");

    }

    @Test
    @DisplayName("charAt() Test")
    void charAt() {
        // 4. "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 StringIndexOutOfBoundsException 테스트 구현
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
