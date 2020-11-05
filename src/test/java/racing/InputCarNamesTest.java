package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racing.view.InputValidator.CAR_NAMES_PATTERN;
import static racing.view.InputValidator.isNull;

import racing.view.InputValidator;

public class InputCarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나", "가나다", "가나다라", "가나다라마"})
    @DisplayName("입력 값이 한글이고 글자 수 제한을 넘지 않는지 확인합니다")
    public void inputKoreanTest(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("입력 값이 영어이고 글자 수 제한을 넘지 않는지 확인합니다")
    public void inputEnglishTest(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,가나", "가,가나,가나다", "가,가나,가나다,가나다라"})
    @DisplayName("콤마가 있는 한글이 정규표현식과 일치하는지 확인합니다")
    public void inputKoreanWithComma(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,ab", "a,ab,abc", "a,ab,abc,abcd"})
    @DisplayName("콤마가 있는 영어가 정규표현식과 일치하는지 확인합니다")
    public void inputEnglishWithComma(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,a", "가나,ab", "가나,ab,다라,cd,마바사,efg"})
    @DisplayName("한글과 영어가 섞여있을 경우 정규표현식과 일치하는지 확인합니다")
    public void inputKoreanAndEnglishTest(String input) {
        assertTrue(isMatch(input));
    }

    @Test
    @DisplayName("글자 수 제한을 넘는 한글이 정규표현식과 일치하지 않는지 확인합니다")
    public void koreanOverSizeTest() {
        assertFalse(isMatch("가나라마바사"));
    }

    @Test
    @DisplayName("글자 수 제한을 넘는 영어이 정규표현식과 일치하지 않는지 확인합니다")
    public void englishOverSizeTest() {
        assertFalse(isMatch("abcdefghi"));
    }

    @Test
    @DisplayName("한글과 영어가 섞여있을 경우 정규표현식과 일치하지 않는지 확인합니다")
    public void inputMixedKoreanAndEnglishTest() {
        assertFalse(isMatch("가a나b"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열이 정규표현식과 일치하지 않는지 확인합니다")
    public void isBlankTest(String input) {
        assertFalse(isMatch(input));
    }

    @Test
    @DisplayName("null 체크가 제대로 동작하는지 확인합니다")
    public void isNullTest() {
        assertTrue(isNull(null));
    }

    private static boolean isMatch(String input) {
        return InputValidator.isMatch(CAR_NAMES_PATTERN, input);
    }
}
