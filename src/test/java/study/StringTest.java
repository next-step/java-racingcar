package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("요구사항 1")
    class Requirement1 {

        @Test
        @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
        void split() {
            String[] result = "1,2".split(",");
            assertThat(result).contains("1");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
        void split2() {
            String[] result = "1".split(",");
            assertThat(result).contains("1");
            assertThat(result).containsExactly("1");
        }
    }
}
