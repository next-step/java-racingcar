package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParsedStringByDelimiterServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "//;|\n1;2",
            "1,2"
    })
    @DisplayName("문자열을 파싱할 수 있다.")
    void a(String inputValue) {
        ParsedStringByDelimiterUseCase sut = new ParsedStringByDelimiterService(inputValue);

        Parsed parsed = sut.parsedString();

        Assertions.assertThat(parsed.parsedValue()).containsExactly("1", "2");
    }

}
