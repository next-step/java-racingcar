package Study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
}
