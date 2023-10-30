package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_test() {
        String str = "1,2";
        String[] strArr = str.split(",");

        assertThat(strArr).containsExactly("1", "2");
    }
}
