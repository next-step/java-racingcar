package study.step_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step_4.ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("자동차 이름이 5글자를 초과할 경우 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource({"가나다라바아, 아자차가하하, 타파하가가"})
    void nameLengthValidation_Fail(String input) {
        assertThatThrownBy(() -> new InputView().validateNameLength(input.split(InputView.REGEX)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이하일 경우 정상적으로 배열에 담기고 반환된다.")
    void nameLengthValidation_Success() {
        String[] expectedResult = {"가나다라아", "아자차가하", "타파하가가"};
        String[] validationNames = new InputView().validateNameLength(expectedResult);
        assertThat(validationNames).containsExactly(expectedResult);
    }


}
