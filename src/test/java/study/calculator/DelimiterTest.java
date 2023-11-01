package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {
    @DisplayName(" 구분자가 없는 문자열이면 기본 구분자를 반환")
    @Test
    void delimiterMustReturnDefaultDelimiter(){
        String target = "a,b,c";
        Delimiter delimiter = new Delimiter(target);
        assertThat(delimiter.delimiter()).isEqualTo(Delimiter.DEFAULT_DELIMITER);
    }

    @DisplayName(" 구분자가 있는 문자열의 구분자를 반환")
    @ParameterizedTest(name = "{0}번째 문자는 {1}")
    @MethodSource
    //@CsvSource(value = {"//;\n1;2;3,;", "//&\n1&2&3&,&", "//+\n1+2+3,+"})
    void delimiterMustReturnCustomDelimiter(String target, String expected){
        Delimiter delimiter = new Delimiter(target);
        assertThat(delimiter.delimiter()).isEqualTo(expected);
    }

    private static Stream<Arguments> delimiterMustReturnCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";"),
                Arguments.of("//&\n1&2&3", "&"),
                Arguments.of("//+\n1+2+3", "+")
        );
    }



}
