package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void split () {
        String[] testData1 = "1,2".split(",");

        assertThat(testData1).contains("1");
        assertThat(testData1).containsExactly("1","2");

        String[] testData2 = "1".split(",");

        assertThat(testData2).contains("1");
        assertThat(testData2).containsExactly("1");
    }

}
