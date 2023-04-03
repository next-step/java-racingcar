package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("String 클래에 대한 학습 테스트")
class StringTest {

    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");
        Assertions.assertAll(
                () -> assertThat(result1).containsExactly("1", "2"),
                () -> assertThat(result2).containsExactly("1")
        );
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
