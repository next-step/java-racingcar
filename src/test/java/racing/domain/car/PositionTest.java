package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.exception.NegativePositionException;

class PositionTest {

    @Test
    @DisplayName("생성 테스트")
    void ctorStateTest() {
        assertDoesNotThrow(() -> new Position());
    }

    @Test
    @DisplayName("음수 예외처리 테스트")
    void negativeTest() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(NegativePositionException.class)
            .hasMessage("음수의 전진 상태는 존재하지 않습니다.");
    }

    @Test
    @DisplayName("상태 +1 테스트")
    void changeStateTest() {
        //given
        Position position = new Position();

        //when
        Position advancePosition = position.advance();

        //then
        assertThat(position).isNotEqualTo(advancePosition);
    }

}