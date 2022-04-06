package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterFinderTest {

    private static final Pattern DELIMITER_PATTERN = Pattern.compile("^//(.)\n");

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> DelimiterFinder.from(DELIMITER_PATTERN));
    }

    @Test
    @DisplayName("구분자 패턴은 필수")
    void instance_nullPattern_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> DelimiterFinder.from(null));
    }

    @Test
    @DisplayName("문자열에 구분자 패턴이 포함되어 있으면 해당 구분자")
    void delimiter_containsPattern() {
        //given, when
        String delimiter = DelimiterFinder.from(DELIMITER_PATTERN).delimiter("//;\n1;2;3");
        //then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("문자열이 null 이라면 기본 구분자")
    void delimiter_null_defaultDelimiter() {
        //given, when
        String delimiter = DelimiterFinder.from(DELIMITER_PATTERN).delimiter(null);
        //then
        assertThat(delimiter).isEqualTo(",|:");
    }

    @Test
    @DisplayName("구분자 패턴이 포함되어 있지 않으면 기본 구분자")
    void delimiter_notContainsPattern_defaultDelimiter() {
        //given, when
        String delimiter = DelimiterFinder.from(DELIMITER_PATTERN).delimiter("abc");
        //then
        assertThat(delimiter).isEqualTo(",|:");
    }

}
