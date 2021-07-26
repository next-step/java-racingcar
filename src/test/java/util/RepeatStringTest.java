package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatStringTest {
    @CsvSource({
            "10,-,----------",
            "5,-,-----",
            "1,-,-"
    })
    @ParameterizedTest
    public void toStringTest(int number, String repeatUnit, String result) {
        assertThat(new RepeatString(number, repeatUnit).toString())
                .isEqualTo(result);
    }
}