package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void splitLearningTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

}
