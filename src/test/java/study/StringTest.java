package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("String 클래스 학습 테스트")
    void split() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1","2");
    }
}
