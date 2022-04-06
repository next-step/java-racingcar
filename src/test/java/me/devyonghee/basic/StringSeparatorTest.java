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

    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringSeparator.from(DELIMITER_PATTERN));
    }

    @Test
    @DisplayName("커스텀 구분자는 필수")
    void instance_nullCustomDelimiter_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringSeparator.from(null));
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열 분리")
    void separate_customDelimiter() {
        //given, when
        List<String> strings = StringSeparator.from(DELIMITER_PATTERN).separate("//;\n1;2;3");
        //then
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자가 포함되지 않으면 기본 구분자로 분리")
    void separate_defaultDelimiter() {
        //given, when
        List<String> strings = StringSeparator.from(DELIMITER_PATTERN).separate("1,2:3");
        //then
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("구분자가 포함되지 않으면 1개의 문자 그대로 반환")
    void separate_notContainsDelimiter() {
        //given
        String any = "any";
        //when
        List<String> strings = StringSeparator.from(DELIMITER_PATTERN).separate(any);
        //then
        assertThat(strings).hasSize(1)
                .containsExactly(any);
    }

    @Test
    @DisplayName("null 을 분리하면 빈 컬렉션")
    void separate_null_emptyStrings() {
        //given, when
        List<String> strings = StringSeparator.from(DELIMITER_PATTERN).separate(null);
        //then
        assertThat(strings).isEmpty();
    }
}
