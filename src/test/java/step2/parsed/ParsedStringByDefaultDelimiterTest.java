package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class ParsedStringByDefaultDelimiterTest {

    @ValueSource(strings = {
            "1,2",
            "1:2"
    })
    @ParameterizedTest
    @DisplayName("쉼표(,)와 콜론(:)을 구분자를 가지는 문자열 일 경우 구분자로 기준으로 분리된 숫자들을 반환한다")
    void a(String stringToBeParsed) {
        Parsed sut = new ParsedStringByDefaultDelimiter(stringToBeParsed);

        List<String> parsedValue = sut.parsedValue();

        Assertions.assertThat(parsedValue).containsExactly("1", "2");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 값이거나 빈 문자열일 때 0을 반환한다.")
    void b(String stringToBeParsed) {
        Parsed sut = new ParsedStringByDefaultDelimiter(stringToBeParsed);

        List<String> parsedValue = sut.parsedValue();

        Assertions.assertThat(parsedValue).containsExactly("0");
    }

}
