package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void stringTest1() {
        String[] multiDigitStrings = "1,2".split(",");

        assertThat(multiDigitStrings).contains("1");
        assertThat(multiDigitStrings).contains("2");

        assertThat(multiDigitStrings).containsExactly("1", "2");

        String[] singleDigitStrings = "1".split(",");

        assertThat(singleDigitStrings).containsExactly("1");
    }

    @Test
    void stringTest2() {
        String strippedString = "(1,2)".substring(1,4);

        assertThat(strippedString).isEqualTo("1,2");
    }

    @Test
    void stringTest3() {

    }
}
