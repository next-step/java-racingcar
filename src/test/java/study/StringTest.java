package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("Split 테스트")
    public void split(){
        java.lang.String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("SubString 테스트")
    void subString(){
        java.lang.String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("예외 발생 테스트")
    void charAt(){
        assertThatThrownBy(() -> {
            char result = "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}