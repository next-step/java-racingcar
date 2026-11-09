import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {



    @Test
    void string_split_test_1() {

        final String INPUT = "1,2";
        String[] numbers = INPUT.split(",");
        Assertions.assertThat(numbers).containsExactly("1", "2");
    }


    @Test
    void string_split_test_2() {

        final String INPUT = "1";
        String[] numbers = INPUT.split(",");
        Assertions.assertThat(numbers).containsExactly("1");
    }


}
