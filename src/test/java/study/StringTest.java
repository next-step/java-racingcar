package study;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] division = "1,2".split(",");
        assertThat(division).containsExactly("1", "2");

        String[] word = "1".split(",");
        assertThat(word).containsExactly("1");
    }


    @Test
    void substring() {
        String word = "(1,2)".substring(1, 4);
        assertThat(word).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져와서 에러 발생여부 확인")
    void charAt() {
        String word = "abc";
        assertThatThrownBy(() -> word.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range:");
    }
}
