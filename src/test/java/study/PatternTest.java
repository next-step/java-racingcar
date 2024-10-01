package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class PatternTest {
    @DisplayName("[study]정규표현식의 Group 기능 + Pattern, Matcher 객체 > 소괄호로 감싼 문자열을 그룹핑해서 캡처링한 그룹을 확인/추출할 수 있다.")
    @Test
    void test() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n2;3");

        assertThat(matcher.matches()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("2;3");
    }
}
