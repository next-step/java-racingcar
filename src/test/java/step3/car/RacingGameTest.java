package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    @Test
    @DisplayName("자동차 대수가 0보다 작으면 예외 발생")
    public void whenMoveCountLessThanZeroThenExceptionTest(){

        // given
        int moveCount = -1;
        int numOfCar = 1;

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RacingGame.of(moveCount, numOfCar)
        );
    }
}