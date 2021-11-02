package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void split() {
        assertThat(getSplitResult("1,2")).contains("1");
        assertThat(getSplitResult("1,2")).containsExactly("1", "2");

        assertThat(getSplitResult("1")).contains("1");
    }

    private String[] getSplitResult(String data) {
        return data.split(",");
    }

}
