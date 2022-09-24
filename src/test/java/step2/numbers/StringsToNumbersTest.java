package step2.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.parsed.Parsed;
import step2.parsed.ParsedStringByDefaultDelimiter;

import java.util.List;

class StringsToNumbersTest {

    @Test
    @DisplayName("파싱된 문자열 리스트를 숫자 리스트로 변환할 수 있다.")
    void a() {
        String stringToBeParsed = "1,2,3";
        Parsed parsed = new ParsedStringByDefaultDelimiter(stringToBeParsed);
        Numbers sut = new StringsToNumbers(parsed);

        List<Integer> numbers = sut.numbers();

        Assertions.assertThat(numbers).containsExactly(1, 2, 3);
    }

}
