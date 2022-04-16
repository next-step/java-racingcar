package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("입력받은 자동차 이름들을 콤마(,)로 자르기")
    void separatorOfInputCarNames() {
        assertThat(InputView.separateInputCars("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @DisplayName("입력된 자동차의 갯수가 1 미만인 경우 예외발생")
    @NullAndEmptySource
    void checkTheNumberOfEnteredCars(String value) {
        assertThatThrownBy(() -> InputView.checkTheNumberOfInputCars(value))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("자동차는 1대 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("입력된 자동차의 이름의 길이가 5자 초과인 경우 예외 발생")
    void checkNameIsLongerThanFiveCharacters() {
        String carName = "pobipobi";

        assertThatThrownBy(() -> InputView.checkLengthCarName(carName))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
}