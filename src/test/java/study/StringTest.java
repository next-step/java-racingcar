package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
       // assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring(){
        String result2 = ("(1,2)").substring(1,4);
        assertThat(result2).isEqualTo("1,2");
    }

    //exception without param
    @Test
    void charAt(){
        assertThatThrownBy(()-> {
                    "abc".charAt(3);
                }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
