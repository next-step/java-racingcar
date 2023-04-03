import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String[] actual = "1,2".split(",");
        Assertions.assertThat(actual).containsExactly("1", "2");

        String[] actual1 = "1".split(",");
        Assertions.assertThat(actual1).containsExactly("1");
    }

    @Test
    void subStringTest() {
        String target = "(1,2)";
        String actual = target.substring(target.indexOf("(") + 1, target.indexOf(")"));
        Assertions.assertThat(actual).isEqualTo("1,2");
    }
}
