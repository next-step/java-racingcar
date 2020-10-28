package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculator {

    private static final Pattern pattern = Pattern.compile("^\\d+$");

    @Test
    @DisplayName("숫자만 있는 문자열을 정규표현식에 맞게 자릅니다")
    public void 숫자만_있는_문자열_파싱_테스트() {
        Matcher matcher = pattern.matcher("1");

        assertTrue(matcher.matches());
    }
}
