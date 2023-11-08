package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.ValidationCheck;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckTest {
    @ParameterizedTest
    @DisplayName("입력된 자동차 이름은 5자를 초과할 수 없다.")
    @ValueSource(strings = {"zbcdef", "123455"})
    public void ValidationCheck_자동차이름_글자수(String input) {
        assertThatThrownBy(() -> ValidationCheck.checkInputCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName(("입력된 자동차 이름은 공백이나 null이 될 수 없다."))
    @NullAndEmptySource
    public void ValidationCheck_자동차이름_공백_null(String input) {
        assertThatThrownBy(() -> ValidationCheck.checkInputCarName(input))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("시도할 횟수는 음수가 될 수 없다.")
    public void ValidationCheck_시도횟수_음수() {
        assertThatThrownBy(() -> ValidationCheck.checkInputTryCount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수에 숫자가 아닌 문자가 들어올 수 없다.")
    public void ValidationCheck_시도횟수_문자() {
        String input = "a";
        assertThatThrownBy(() -> ValidationCheck.checkInputTryCount(Integer.parseInt(input))).isInstanceOf(IllegalArgumentException.class);
    }
}
