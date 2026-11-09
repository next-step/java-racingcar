import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {



    @Test
    void string_split_test_1() {

        final String input = "1,2";
        String[] numbers = input.split(",");
        Assertions.assertThat(numbers).containsExactly("1", "2");
    }


    @Test
    void string_split_test_2() {

        final String input = "1";
        String[] numbers = input.split(",");
        Assertions.assertThat(numbers).containsExactly("1");
    }


    @Test
    void string_split_test_3() {

        final String input = "(1,2)";

        String output = input.substring(1,4);

        Assertions.assertThat(output).isEqualTo("1,2");
    }


}
