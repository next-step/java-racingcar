import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {



    @Test
    void string_split_test() {

        final String INPUT = "1,2";
        String[] numbers = INPUT.split(",");
        Assertions.assertThat(numbers).containsExactly("1", "2");
    }


}
