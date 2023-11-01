package study;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("Index 위치를 벗어나는 경우, 오류가 발생한다.")
    void exceptionTest() {
//        assertThrows(IndexOutOfBoundsException.class,
//                () -> "abc".charAt(4));

        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
