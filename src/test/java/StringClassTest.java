import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringClassTest {
    @Test
    void splitTest() {
        final String input1 = "1,2";

        String[] split1 = input1.split(",");
        Assertions.assertThat(split1).containsExactly("1", "2");

        final String input2 = "1";
        String[] split2 = input2.split(",");
        Assertions.assertThat(split2).containsExactly("1");
    }

    @Test
    void substringTest() {
        final String input = "(1,2)";
        String substring = input.substring(1, 4);
        Assertions.assertThat(substring).isEqualTo("1,2");
    }
}
