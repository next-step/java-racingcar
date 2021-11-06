package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.InputValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputUtilsTest {

    @DisplayName("입력한 값을 InputValue객체로 변경")
    @ParameterizedTest
    @CsvSource(value = {
            "3 | 4",
            "5 | 6",
            "8 | 6"
    }, delimiter = '|')
    void convertInputValue(String numberOfCars, String numberOfAttempts) {
        assertThat(InputUtils.convertInputValue(numberOfCars, numberOfAttempts)).isInstanceOf(InputValue.class);
    }

    @DisplayName("입력한 값이 공백이 있을경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "3 | ''",
            "'' | 5",
            "'' | ''"
    }, delimiter = '|')
    void validateEmptySource(String numberOfCars, String numberOfAttempts) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> InputUtils.convertInputValue(numberOfCars, numberOfAttempts))
                .withMessage("공백은 입력할 수 없습니다.");
    }

    @DisplayName("입력한 값이 문자열이 있을경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "3 | '문자열입니다.'",
            "'다시 작성할게요' | 5",
            "'잘못 작성' | '문자열입니다2'"
    }, delimiter = '|')
    void validateString(String numberOfCars, String numberOfAttempts) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputUtils.convertInputValue(numberOfCars, numberOfAttempts))
                .withMessage("회수를 입력해주세요.");
    }

    @DisplayName("입력한 값이 0이 있을경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "3 | '0'",
            "0 | 5",
            "0 | 0"
    }, delimiter = '|')
    void validateZero(String numberOfCars, String numberOfAttempts) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputUtils.convertInputValue(numberOfCars, numberOfAttempts))
                .withMessage("입력값은 1이상으로 입력해주세요.");
    }

}