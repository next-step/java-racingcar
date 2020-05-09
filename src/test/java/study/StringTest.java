package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    @DisplayName("getAssertion_charAt")
    void position() {
        String result = "abc";
        assertThat(result.charAt(0)).isEqualTo('a');
    }
    @Test
    @DisplayName("exceptionTryCatch")
    void position1() {
        String result = "abc";
        try{
            System.out.println(result.charAt(3));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    @Test
    @DisplayName("exceptionAssertj")
    void position2() {
        String result = "abc";
        assertThatThrownBy(()->{
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }
    @Test
    @DisplayName("list_assertj")
    void position3() {
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                //... https://www.baeldung.com/assertj-exception-assertion참고
                .hasMessageMatching("Index 2 out of bounds for length \\d");
    }
}
