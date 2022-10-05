package learning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split(){
        String input1 = "1,2";
        String input2 = "1";
        String separator = ",";

        String[] result1 = input1.split(separator);
        String[] result2 = input2.split(separator);

        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring(){
        String input1 = "(1,2)";

        String result1 = input1.substring(input1.indexOf('1'), input1.indexOf('2') + 1);

        assertThat(result1).isEqualTo("1,2");
    }

    @Test
    void chatAt(){
        String input1 = "abc";

        char result1 = input1.charAt(0);
        char result2 = input1.charAt(2);
        char result3 = input1.charAt(1);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('c');
        assertThat(result3).isEqualTo('b');
    }

    @Test
    void chatAt_예외(){
        String input1 = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input1.charAt(5);
                }).withMessageMatching("String index out of range: 5");
    }
}
