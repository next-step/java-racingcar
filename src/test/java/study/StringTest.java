package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void charAt(){
        String str = "abc";
        char c = str.charAt(0);
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 예외발생 테스트")
    void charAtException(){
        String str = "abc";
        int index = 4;
        assertThatThrownBy(()->{
            str.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

}
