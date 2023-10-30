package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1, 2가 ,로 스플릿하면 1 2 로 분리된다.")
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }
}
