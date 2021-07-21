package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void substring(){
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("charAt learning test")
    void charAt(){
        char firstCharacter = "abc".charAt(0);
        assertThat(firstCharacter).isEqualTo('a');
    }

    @Test
    @DisplayName("throw exception StringIndexOutOfBound")
    void charAt2(){
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
