package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split_mulit(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    void split_single(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chaAt(){
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("chaAt 메서드 StringIndexOutOfBoundsException 테스트")
    @Test
    void chaAt_exception(){
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");
    }
}
