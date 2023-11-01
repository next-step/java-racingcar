package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String data = "(1,2)".substring(1,4);
        assertThat(data).contains("1,2");
    }

    @Test
    @DisplayName("예상한 올바른 예외를 뱉는지, 에외 메세지가 일치하는지 확인")
    void charAt() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }


}
