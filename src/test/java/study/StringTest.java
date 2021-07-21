package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("String 1과 2를 split으로 나누고 결과 값이 예상한 결과와 일치하는지 확인")
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환")
    @Test
    void split2() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt() 메소드를 이용하여 특정 위치의 문자열을 가져오는 테스트를 진행")
    @Test
    void split3() {
        assertThatThrownBy(()->{
            char result = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
