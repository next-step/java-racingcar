package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculator {

    private static final Pattern pattern = Pattern.compile("^([\\d])([+-/*]\\d)*$");

    @Test
    @DisplayName("숫자만 있는 문자열을 정규표현식에 맞게 자릅니다")
    public void 숫자만_있는_식_파_테스트() {
        final String expression = "1";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());

        // 숫자와 null 두 개의 그룹으로 나뉩니다
        assertThat(matcher.groupCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("부호가 같이 있는 문자열을 정규표현식에 맞게 자릅니다")
    public void 부호가_있는_식_파싱_테스트() {
        final String expression = StringUtils.replaceWhitespaceCharacters("1 + 2", "");
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());

        assertThat(matcher.group(1)).isEqualTo("1");
        assertThat(matcher.group(2)).isEqualTo("+2");
    }
}
