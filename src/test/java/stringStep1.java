import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class stringStep1 {

    @Test
    public void stringStep1_1() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1", "2");
    }

    @Test
    public String stringStep1_2() {
        String numberSub = "(1,2)";
        String numSub = numberSub.substring(1,4);

        return numSub;
    }
    @Test
    @DisplayName("indexExceptionTest")
    public void stringStep1_3() {
            String abc = "abc";
            char abcException = abc.charAt(10);
    }
}
