package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @ParameterizedTest
    @DisplayName("정규식에 사용되는 symbol 변환 테스트")
    @CsvSource(value = {"^, \\^", "$^, \\$\\^", "!^, !\\^", "$!^, \\$!\\^"})
    void valueOfRegexTest(String input, String expected) {
        assertThat(new Delimiter(input).valueOfRegex()).isEqualTo(expected);
    }
}