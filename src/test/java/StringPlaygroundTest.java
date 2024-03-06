import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPlaygroundTest {

    @Test
    public void requirement1() {
        String[] result = "1,2".split(",");
        assertThat(result).hasSize(2);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }
}
