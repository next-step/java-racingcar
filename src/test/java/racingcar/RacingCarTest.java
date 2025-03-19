package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void 초기_상태에서_display는_빈_문자열이다() {
        RacingCar car = new RacingCar();
        assertThat(car.display()).isEqualTo("");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,---", "1,-", "2,--"})
    public void move를_하면_MOVE_SYMBOL이_추가된다(int moveCount, String expected) {
        RacingCar car = new RacingCar(new AlwaysRacingCarMoveStrategy());

        for (int i = 0; i < moveCount; i++) {
            car.moveIfMovable();
        }

        assertThat(car.display()).isEqualTo(expected);
    }
}
