package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("String 1과 2를 split으로 나누고 결과 값이 예상한 결과와 일치하는지 확인")
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @DisplayName("substring 활용")
    @Test
    void split2() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }




}
