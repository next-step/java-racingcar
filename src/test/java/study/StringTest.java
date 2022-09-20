package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split 배열 반환 테스트")
    void split(){
        String[] splitArrayContainOneAndTwo = "1,2".split(",");
        assertThat(splitArrayContainOneAndTwo).contains("1","2");

        String[] splitArrayContainOne = "1,".split(",");
        assertThat(splitArrayContainOne).containsExactly("1");
    }

    @Test
    @DisplayName("substring () 제거 테스트")
    void substring(){
        String substringRemoveBracket = "(1,2)".substring(1,4);
        assertThat(substringRemoveBracket).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 실행 StringIndexOutOfBoundsException 테스트")
    void charAt(){

        String abc = "abc";

        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    abc.charAt(3);
                }).withMessageMatching("String index out of range: [0-9]+");
    }
}
