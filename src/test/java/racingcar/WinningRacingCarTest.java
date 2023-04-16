package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningRacingCarTest {

    @DisplayName("자동차 이름 5자 초과시 예외 처리")
    @Test
    void carNameLengthException() {
        assertThatThrownBy(() -> {
            new WinningRacingCar("hoyeon");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}