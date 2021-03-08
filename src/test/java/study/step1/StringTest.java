package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName(",로 문자열 구분")
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1","3");
    }
    @Test
    @DisplayName("()를 제외한 문자열만 남기기")
    void substring() {
        String data = "(1,2)".substring(1,4);
        assertThat(data).contains("1,2");
    }

    @Test
    @DisplayName("String Index out of bounds exception test")
    void charAt(){
        String data = "abc";
        assertThatThrownBy(()->{
            data.charAt(1);
            data.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

}
