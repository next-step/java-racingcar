package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static common.ErrorMessage.INVALID_VALUE;
import static common.ErrorMessage.NOT_NULL;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.view.InputValidator.CAR_NAMES_PATTERN;
import static racing.view.InputValidator.validate;

public class InputCarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나", "가나다", "가나다라", "가나다라마"})
    @DisplayName("입력 값이 한글이고 글자 수 제한을 넘지 않는지 확인합니다")
    public void inputKoreanTest(String input) {
        doesNotThrow(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("입력 값이 영어이고 글자 수 제한을 넘지 않는지 확인합니다")
    public void inputEnglishTest(String input) {
        doesNotThrow(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,가나", "가,가나,가나다", "가,가나,가나다,가나다라"})
    @DisplayName("콤마가 있는 한글이 정규표현식과 일치하는지 확인합니다")
    public void inputKoreanWithComma(String input) {
        doesNotThrow(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,ab", "a,ab,abc", "a,ab,abc,abcd"})
    @DisplayName("콤마가 있는 영어가 정규표현식과 일치하는지 확인합니다")
    public void inputEnglishWithComma(String input) {
        doesNotThrow(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,a", "가나,ab", "가나,ab,다라,cd,마바사,efg"})
    @DisplayName("한글과 영어가 섞여있을 경우 정규표현식과 일치하는지 확인합니다")
    public void inputKoreanAndEnglishTest(String input) {
        doesNotThrow(input);
    }

    @Test
    @DisplayName("글자 수 제한을 넘는 한글이 정규표현식과 일치하지 않는지 확인합니다")
    public void koreanOverSizeTest() {
        throwIllegalArgumentException("가나다라마바사", INVALID_VALUE);
    }

    @Test
    @DisplayName("글자 수 제한을 넘는 영어이 정규표현식과 일치하지 않는지 확인합니다")
    public void englishOverSizeTest() {
        throwIllegalArgumentException("abcdefghi", INVALID_VALUE);
    }

    @Test
    @DisplayName("한글과 영어가 섞여있을 경우 정규표현식과 일치하지 않는지 확인합니다")
    public void inputMixedKoreanAndEnglishTest() {
        throwIllegalArgumentException("가a나b", INVALID_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열이 정규표현식과 일치하지 않는지 확인합니다")
    public void isBlankTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @Test
    @DisplayName("null 체크가 제대로 동작하는지 확인합니다")
    public void isNullTest() {
        throwIllegalArgumentException(null, NOT_NULL);
    }

    private static void doesNotThrow(String input) {
        assertThatThrownBy(() -> validate(input, CAR_NAMES_PATTERN))
                .doesNotThrowAnyException();
    }

    private static void throwIllegalArgumentException(String input, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validate(input, CAR_NAMES_PATTERN))
                .withMessage(message);
    }
}
