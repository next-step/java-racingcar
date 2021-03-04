package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1,2를 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] actual = "1,2".split(",");

        assertThat(actual).containsExactly("1", "2");
    }
}
