package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.GameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름은 공백이 있더라도 1자 이상 5자 이하면 가능하다.")
    @Test
    void carNameSuccessTest() {
        String input = " 붕붕이 ";
        CarName carName = CarName.of(input);

        assertThat(carName.getName()).isEqualTo(input.trim());
    }

    @DisplayName("자동차 이름이 공백 없이 6자 이상일 경우 예외가 발생한다.")
    @Test
    void carNameFailTest() {
        String input = " 붕붕이자동차 ";

        assertThatThrownBy(() -> CarName.of(input))
                .isInstanceOf(GameException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }
}