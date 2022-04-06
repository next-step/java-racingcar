package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringFilterTest {

    private static final Pattern FILTER_PATTERN = Pattern.compile("^//(.)\n");

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringFilter.from(FILTER_PATTERN));
    }

    @Test
    @DisplayName("제거할 패턴은 필수")
    void instance_nullPattern_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringFilter.from(null));
    }

    @Test
    @DisplayName("문자열에 패턴이 포함되어 있으면 패턴 문자 제거")
    void string() {
        //given, when
        String filteredString = StringFilter.from(FILTER_PATTERN).filter("//;\n1;2;3");
        //then
        assertThat(filteredString).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("패턴이 포함되어 있지 않으면 그대로 반환")
    void string_notContains() {
        //given, when
        String abc = "abc";
        String filteredString = StringFilter.from(FILTER_PATTERN).filter(abc);
        //then
        assertThat(filteredString).isEqualTo(abc);
    }

    @Test
    @DisplayName("주어진 문자가 null 이라면 IllegalArgumentException")
    void string_null_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringFilter.from(FILTER_PATTERN).filter(null));
    }
}
