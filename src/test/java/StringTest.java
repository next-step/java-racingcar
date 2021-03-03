import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String split by token common(,)")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    @DisplayName("String substring from 1 to length-1")
    void substring(){
        String param = "(1,2)";
        String result = param.substring(1, param.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt method Test - success")
    void charAtSuccess(){
        String param = "abc";

        assertThat(param.charAt(2)).isEqualTo('c');
    }
    @Test
    @DisplayName("charAt method Test - fail")
    void charAtFail(){
        String param = "abc";

        assertThatThrownBy(()->param.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
