import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("Case1: Split string by comma")
    void request1() {
        String[] req1_value = "1,2".split(",");
        assertThat(req1_value).contains("1", "2");
    }

    @Test
    @DisplayName("Case1-2: Split String by comma, ordered")
    void request1_2() {
        String[] req1_2_value = "1,2".split(",");
        assertThat(req1_2_value).containsExactly("1", "2");
    }

    @Test
    @DisplayName("Case2: Remove parentheses using substring method")
    void request2() {
        String req2_value = "(1,2)".substring(1, 4);
        assertThat(req2_value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Case3: Test of IndexOutOfBoundsException with assertThatThrownBy()")
    void request3() {
        String req3_value = "abc";

        //Case of StringIndexOutOfBoundsException
        // An error occurs.
        //assertThat(req3_value.charAt(4)).isEqualTo("c");

        //Case for Exception Assertion
        //Message is created from the Exception,
        //so I type the expecting message into a parameter of hasMessageContaining
        assertThatThrownBy(() -> {
                    req3_value.charAt(4);
                }
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4")
        ;
    }

    @Test
    @DisplayName("Case3-1: Test of IndexOutOfBoundsException with assertTHatExceptionOfType()")
    void request3_1() {
        String req3_1_value = "abc";
        //Another Exception handle case for a unit test
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                            req3_1_value.charAt(4);
                        }
                ).withMessageMatching("String index out of range: \\d+");
    }
}
