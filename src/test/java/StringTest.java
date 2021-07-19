import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split_배열에_1과_2가_존재하는가() {
        String result[] = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_배열에_1이_존재하는가() {
        final String one = "1";
        String result[] = one.split(",");
        assertThat(result).containsExactly(one);
    }
}
