package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    public void test_split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }
    
    @Test
    public void test_substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 위치값을 벗어나면 예외가 발생해야한다.")
    public void test_exception(){
        StringIndexOutOfBoundsException e = assertThrows(StringIndexOutOfBoundsException.class,
                () -> "test".charAt(10));
    }

}
