package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {

        String[] resultData = "1,2".split(",");
//        assertThat(resultData).contains("1");
        //순서까지 확인.
        assertThat(resultData).containsExactly("1","2");
    }
}
