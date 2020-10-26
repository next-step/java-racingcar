package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split(){
        String[] data = "1,2".split(",");
        Assertions.assertThat(data).containsExactly("1","2");
    }
}
