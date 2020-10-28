package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorMatchTest {

    private static final Pattern pattern = Pattern.compile("^(-?[\\d])([+-/*]\\d)*$");

    @Test
    @DisplayName("양수만 있는 식이 정규표현식과 맞는지 확인합니다")
    public void 양수만_있는_식_매치_테스트() {
        final String expression = "1";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("음수만 있는 식이 정규표현식과 맞는지 확인합니다")
    public void 음수만_있는_식_매치_테스트() {
        final String expression = "-1";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("부호가 한 개 있는 식이 정규표현식과 맞는지 확인합니다")
    public void 부호가_한_개있는_식_매치_테스트() {
        final String expression = "1+2";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("부호가 여러 개 있는 식이 정규표현식과 맞는지 확인합니다")
    public void 부호가_여러_개있는_식_매치_테스트() {
        final String expression = "1+2-3*4/5";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("처음 숫자가 음수이고 부호가 여러 개 있는 식이 정규표현식과 맞는지 확인합니다")
    public void 처음_숫자가_음수이고_부호가_여러_개있는_식_매치_테스트() {
        final String expression = "1+2-3*4/5";
        final Matcher matcher = pattern.matcher(expression);

        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("잘못된 형식의 식이 정규표현식과 맞는지 확인합니다")
    public void 잘못된_형식의_식_매치_테스트() {
        final String expression = "1+2-";
        final Matcher matcher = pattern.matcher(expression);

        assertFalse(matcher.matches());
    }
}
