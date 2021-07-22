package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자 분리하기")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

        result = "1,".split(",");
        assertThat(result).containsExactly("1");

    }

    @Test
    @DisplayName("문자 잘라내기")
    void substring(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자 가져오기")
    void charAt(){
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');

        assertThatThrownBy(() -> { "abc".charAt(3); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}

