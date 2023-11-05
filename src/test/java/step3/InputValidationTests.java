package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.validation.ValidateCarsInput;
import step3.validation.ValidateRaceTimeInput;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTests {

    @ParameterizedTest
    @ValueSource(ints = {-1})
    @DisplayName("전진 횟수를 음수 값으로 넣으면 예외가 발생한다.")
    void negativeTimes(int times) {
        assertThatThrownBy(() -> ValidateRaceTimeInput.range(times))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("전진하는 조건은 0 ~ 9 사이 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("전진 횟수를 9 이상의 숫자를 넣을 경우 예외가 발생한다.")
    void outOfRange(int times) {
        assertThatThrownBy(() -> ValidateRaceTimeInput.range(times))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("전진하는 조건은 0 ~ 9 사이 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("4 이하의 숫자를 넣었을 경우 경주를 시작할 수 없다는 예외가 발생한다.")
    void canRaceStart(int times) {
        assertThatThrownBy(() -> Cars.isMovable(times))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("4 이상부터 경주를 시작할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-5})
    @DisplayName("자동차 대수를 음수 값을 넣으면 예외가 발생한다.")
    void negativeCars(int cars) {
        assertThatThrownBy(() -> ValidateCarsInput.positiveNumber(cars))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 대수는 음수 값을 입력할 수 없습니다.");
    }
}
