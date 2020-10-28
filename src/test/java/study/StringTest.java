package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트
        assertThat(result).containsExactly("1", "2");

        //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        // (1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현
        String result = "(1,2)";
        assertEquals("1,2", result.substring(1, result.length() - 1));
    }
}
