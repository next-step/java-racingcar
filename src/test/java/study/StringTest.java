package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("string을 split했을때 잘 분리되는지 확인")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)를 substring 했을때 잘 잘리는지 확인")
    void substring() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt에서 인덱스를 벗어나는 경우  오류 발생 학인")
    void chatAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining(String.format("String index out of range: %d", 4));
    }
}
