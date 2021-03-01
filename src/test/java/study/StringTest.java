package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        //.contains("3");               값이 있는지 체크
        //.containsExactly("1","2")     + 순서까지 체크
        assertThat(result).containsExactly("1","2");
    }
}
