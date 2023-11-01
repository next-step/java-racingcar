package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringDelimiterTest {

    private static String DEFAULT_DELIMITER = ",|:";

    @DisplayName(" 기본 구분자 \",\", \":\" 를 뺀 문자열을 반환")
    @Test
    void checkDefaultDelimiter(){
        String target = "1,2,3";
        StringDelimiter stringDelimiter = new StringDelimiter(new Delimiter(target));
        List<String> stringList = stringDelimiter.filteredString(target);
        assertThat(stringList).doesNotContain(",");
    }

    @DisplayName(" 커스텀 구분자 \":\" 을 뺀 문자열을 반환" )
    @ParameterizedTest
    @MethodSource
    void checkCustomDelimiter(String target, String expected){
        StringDelimiter stringDelimiter = new StringDelimiter(new Delimiter(target));
        List<String> stringList = stringDelimiter.filteredString(target);
        assertThat(stringList).doesNotContain(expected);
    }

    private static Stream<Arguments> checkCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";"),
                Arguments.of("//&\n7&8&9", "&"),
                Arguments.of("//+\n5+36+21", "+")
        );
    }


}
