package Study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Java6Assertions.*;
public class StringTest {

    @Test
    public void test1() {
        String str1 = "1,2";
        String str2 = "1";

        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");

        assertThat(split1).contains("1", "2");
        assertThat(split2).containsExactly("1");
    }
}
