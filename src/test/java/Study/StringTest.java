package Study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split(){
        String[] test12 = "1,2".split(",");
        assertThat(test12).contains("1");
        assertThat(test12).containsExactly("1","2");
    }
}
