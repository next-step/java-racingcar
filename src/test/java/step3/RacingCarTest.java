package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("move의 결과값 확인하기")
    void move() {
        RacingCar racingCar = new RacingCar();

        int moveCount = racingCar.move();

        assertThat(moveCount).isBetween(0, 10);
    }

}