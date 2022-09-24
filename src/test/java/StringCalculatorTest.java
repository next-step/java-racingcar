import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void addStringNumber_숫자() {
        String firstCase = "1,2,3";
        String secondCase = "4:5";

        long firstExpected = 6;
        long secondExpected = 9;

        assertAll(
                () -> assertThat(stringCalculator.addStringNumber(firstCase)).isEqualTo(firstExpected),
                () -> assertThat(stringCalculator.addStringNumber(secondCase)).isEqualTo(secondExpected)
        );
    }

    @Test
    public void addStringNumber_null_또는_빈문자() {
        String emptyString = "";

        long expected = 0;

        assertAll(
                () -> assertThat(stringCalculator.addStringNumber(emptyString)).isEqualTo(expected),
                () -> assertThat(stringCalculator.addStringNumber(null)).isEqualTo(expected)
        );
    }

    @Test
    public void addStringNumber_문자() {
        String character = "a:b:c:1:2";

        assertThatThrownBy(() -> stringCalculator.addStringNumber(character)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void addStringNumber_음수() {
        String negative = "-1,2";

        assertThatThrownBy(() -> stringCalculator.addStringNumber(negative)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void addStringNumber_쉼표_또는_콜론() {
        String firstCase = "1,2,3:4";

        long expected = 10;

        assertThat(stringCalculator.addStringNumber(firstCase)).isEqualTo(expected);
    }

    @Test
    public void addStringNumber_커스텀_구분자() {
        String firstCase = "//;\n1;2;3";

        long expected = 6;

        assertThat(stringCalculator.addStringNumber(firstCase)).isEqualTo(expected);
    }
}
