package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    void splitCheckContainsExactly() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }
}
