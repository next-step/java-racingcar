package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
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

    @Test
    public void test2() {
        String str = "(1,2)";

        str = str.substring(1, str.length()-1);

        assertThat(str).doesNotContain("(",")");
        assertThat(str).isEqualTo("1,2");
    }
}
