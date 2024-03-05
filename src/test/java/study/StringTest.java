package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String data = "1,2";
        String[] result = data.split(",");
        // 결과확인
        assertThat(result).containsExactly("1", "2");
    }

}
