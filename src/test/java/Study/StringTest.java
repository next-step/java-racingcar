package Study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split(){
        String[] stringTest1 = "1,2".split(",");
        assertThat(stringTest1).contains("1","2");

        String[] stringTest2 = "1".split(",");
        assertThat(stringTest2).containsExactly("1");
    }

    @Test
    void testSubstring(){
        assertThat(substring("(1,2)")).contains("1,2");
    }

    public String substring(String s){
        return s.substring(1,4);
    }

    @Test
    @DisplayName("CharAt()의 문자 Test, OutOfBoundException Test")
    void testCharat(){
        String s = "abc";
        assertThat(s.charAt(0)).isEqualTo('a');
        assertThat(s.charAt(1)).isEqualTo('b');
        assertThat(s.charAt(2)).isEqualTo('c');

        assertThatThrownBy(()->{
            s.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

}
