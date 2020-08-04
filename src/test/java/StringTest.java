import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1")
                .contains("2");

        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    public void substring() {
        String value = "(1,2)";
        int begininIndex = value.indexOf("(");
        int endIndex = value.indexOf(")");

        String result = value.substring(begininIndex + 1, endIndex);
        assertThat(result).isEqualTo("1,2");
    }
}
