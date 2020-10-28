package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void name() {
         String[] result = "1,2".split(",");
//         assertThat(result).contains("1");
         assertThat(result).contains("1", "2");
    }
}
