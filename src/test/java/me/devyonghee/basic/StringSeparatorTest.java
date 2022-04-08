package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 분리")
class StringSeparatorTest {

    private static final Pattern PATTERN = Pattern.compile("^//(.)\n");
    private static final StringFilter STRING_FILTER = StringFilter.from(PATTERN);
    private static final DelimiterFinder DELIMITER_FINDER = DelimiterFinder.from(PATTERN);
    private static final StringSeparator STRING_SEPARATOR = StringSeparator.of(STRING_FILTER, DELIMITER_FINDER);

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringSeparator.of(STRING_FILTER, DELIMITER_FINDER));
    }

    @Test
    @DisplayName("필터와 구분자 탐지기는 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringSeparator.of(STRING_FILTER, null));
        assertThatIllegalArgumentException().isThrownBy(() -> StringSeparator.of(null, DELIMITER_FINDER));
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열 분리")
    void separate_customDelimiter() {
        //given, when
        List<String> strings = STRING_SEPARATOR.separate("//;\n1;2;3");
        //then
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자가 포함되지 않으면 기본 구분자로 분리")
    void separate_defaultDelimiter() {
        //given, when
        List<String> strings = STRING_SEPARATOR.separate("1,2:3");
        //then
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("구분자가 포함되지 않으면 1개의 문자 그대로 반환")
    void separate_notContainsDelimiter() {
        //given
        String any = "any";
        //when
        List<String> strings = STRING_SEPARATOR.separate(any);
        //then
        assertThat(strings).hasSize(1)
                .containsExactly(any);
    }

    @Test
    @DisplayName("분리 대상이 null이라면 IllegalArgumentException")
    void separate_null_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> STRING_SEPARATOR.separate(null));
    }
}
