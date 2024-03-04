import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void split_test() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
}
