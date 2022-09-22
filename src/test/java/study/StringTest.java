package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test   // 요구사항1
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test   // 요구사항2
    void subString(){
        String str = "(1,2)";
        String result = str.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test   // 요구사항3
    @DisplayName("StringIndexOutOfBoundsException 처리 테스트")
    void charAt() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class) .isThrownBy( () -> {
            char result = str.charAt(4);
        }).withMessageMatching("String index out of range: 4"); // withMessageMatching 를 이렇게 쓰는 것이 맞을까요?
    }


}
