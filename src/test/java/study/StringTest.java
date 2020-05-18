package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
    
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }
    
    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }
    
    @Test
    @DisplayName("charAt() 메소드 특정 위치 문자 가져오기 테스트")
    void charAt() {
        char result = "ABC".charAt(2);
        assertThat(result).isEqualTo('C');
    }

    @Test
    @DisplayName("charAt() 메소드 StringIndexOutOfBoundsException발생 테스트")
    void charAt2() {
        assertThatThrownBy(() -> {
            char result = "ABC".charAt(3);
            System.out.println(result);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessage("String index out of range: 3");
    }

}