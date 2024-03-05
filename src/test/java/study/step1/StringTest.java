package study.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String str = "1,2";
        String[] splitResult = str.split(",");
        Assertions.assertThat(splitResult).containsExactly("1","2");
    }
}
