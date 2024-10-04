package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @DisplayName("요구사항 3 - 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception이 발생하는 부분에 대한 학습 테스트")
    @Test
    void charAt() {
        assertThatThrownBy(()->
                "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}
