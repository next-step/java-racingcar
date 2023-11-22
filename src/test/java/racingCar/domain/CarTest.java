package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("플레이어의 이름은 5자 이하로 입력되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"iamsix", "seven77"})
    void inputPlayer(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.from(input))
                .withMessage("이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("플레이어의 이름은 5자 이하로 입력되면 예외를 던지지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"crong", "pobi"})
    void inputPlayerValid(String input) {
        assertThatCode(() -> Car.from(input))
                .doesNotThrowAnyException();
    }
}
