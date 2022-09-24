package step2.calculated;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.parsed.Parsed;
import step2.parsed.ParsedStringByDefaultDelimiter;

class CalculatedStringTest {

    @Test
    @DisplayName("문자열을 계산할 수 있다.")
    void a() {
        String inputValue = "1,2,3";
        Parsed parsed = new ParsedStringByDefaultDelimiter(inputValue);
        Calculated sut = new CalculatedString(parsed);

        int calculatedResult = sut.calculatedResult();

        Assertions.assertThat(calculatedResult).isEqualTo(6);
    }
}
