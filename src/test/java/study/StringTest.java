package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 \",\"로 split 했을 때 1과 2로 분리된다.")
    void split_multiple() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때 1을 포함하는 배열이 반환된다.")
    void split_single() {
        String[] result = "1".split(",");
        Assertions.assertThat(result).containsExactly("1");
    }
}
