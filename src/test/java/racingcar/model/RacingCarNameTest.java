package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarNameTest {
    @Test
    @DisplayName("RacingCars 객체를 만들 때 5자 이상의 이름을 입력하면 예외가 발생한다.")
    void create_racing_cars_negative() throws Exception {
        assertThatThrownBy(() -> RacingCars.create("qwertyasdfg"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
