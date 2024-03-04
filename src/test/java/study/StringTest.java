package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void testSplitManyNumberWithComma() {
        String[] testData = "1,2".split(",");
        assertThat(testData).containsExactly("1","2");
    }

    @Test
    void testSplitSingleNumberWithComma() {
        String[] testData ="1".split(",");
        assertThat(testData).containsExactly("1");
    }

}
