package step1_study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SplitTest {

    @Test
    public void 요구사항1_test() {
        String data = "1,2";
        assertThat(data.split(",")).contains("1");
        assertThat(data.split(",")).containsExactly("1", "2");
        assertThat(data.split(",")).containsExactly(new String[]{"1", "2"});
    }

    @Test
    void 요구사항2_test() {
        String data = "(1,2)";
        assertThat(data.substring(1, data.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("indexOutofBoundException 테스트")
    @Test
    void 요구사항3_test() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
