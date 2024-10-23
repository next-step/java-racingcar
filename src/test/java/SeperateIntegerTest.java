import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeperateIntegerTest {
    @Test
    void seperate()
    {
        String source = "1,2";
        String[] splits = source.split(",");

        assertThat(splits).contains("1");
        assertThat(splits).contains("2");
        assertThat(splits).containsExactly("1", "2");
    }
}
