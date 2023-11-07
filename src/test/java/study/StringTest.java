package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        //contains 성공 케이스
        assertThat(result).contains("1"); //배열에 포함되어 있으면 성공(중복도 가능), 순서가 달라도 성공
        assertThat(result).contains("2", "1");

        //containsExactly 성공
        assertThat(result).containsExactly("1", "2"); //배열에 포함되어 있으며 순서까지 일치해야 함.
        
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAt() {
        String result = "abc";
        assertThatThrownBy(() -> {
           result.charAt(5);
            throw new IndexOutOfBoundsException("5");
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("5");
    }
}
