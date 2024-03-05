package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("요구사항1: ,로 split 했을 때 1과 2로 분리")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1: ,로 split 했을 때 1만 반환")
    void splitSingleItem() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }
}