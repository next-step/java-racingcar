package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SplitTest {

    @Test
    void split_리턴_배열_contains_테스트() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }
}
