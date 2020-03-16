package step1_study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SplitTest {

    @Test
    public void 요구사항1_test() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1,2".split(",")).contains("2");
        assertThat("1,2".split(",")).containsExactly(new String[]{"1", "2"});

        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 요구사항2_test() {
        String data = "(1,2)";
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value = "Exception이 발생하는 클래스의 테스트를 구현해봄")
    void 요구사항3_test() {
        String data = "abc";
//        Throwable exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
//            data.charAt(2);
//            throw new StringIndexOutOfBoundsException("out of index");
//        });

        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("out of range");
    }
}
