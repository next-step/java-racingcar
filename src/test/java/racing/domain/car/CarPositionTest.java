package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.exception.NegativePositionException;

class CarPositionTest {

    @Test
    @DisplayName("생성 테스트")
    void ctorStateTest() {
        assertDoesNotThrow(() -> new CarPosition());
    }

    @Test
    @DisplayName("음수 예외처리 테스트")
    void negativeTest() {
        assertThatThrownBy(() -> new CarPosition(-1))
            .isInstanceOf(NegativePositionException.class)
            .hasMessage("음수의 전진 상태는 존재하지 않습니다.");
    }

    @Test
    @DisplayName("상태 +1 테스트")
    void changeStateTest() {
        //given
        CarPosition carPosition = new CarPosition();

        //when
        CarPosition advanceCarPosition = carPosition.advance();

        //then
        assertThat(advanceCarPosition.value()).isEqualTo(1);
    }

}