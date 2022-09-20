package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] splitArray1 = "1,2".split(",");
        Assertions.assertThat(splitArray1).contains("1", "2");

        String[] splitArray2 = "1".split(",");
        Assertions.assertThat(splitArray2).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";

        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));

        Assertions.assertThat(result).isEqualTo("1,2");
    }

}
