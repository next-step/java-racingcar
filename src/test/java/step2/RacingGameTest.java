package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 레이싱 ")
    void moveTest() {
        int carNumber = 4;
        RacingGame racingGame = new RacingGame();
        racingGame.carPositionsInit(carNumber);

        List<Integer> carPositionList = racingGame.move();
        int sumCarPosition = carPositionList.stream().reduce(0, (a, b) -> a + b);
        assertThat(sumCarPosition).isEqualTo(4);

        carPositionList = racingGame.move();
        sumCarPosition = carPositionList.stream().reduce(0, (a, b) -> a + b);
        assertThat(sumCarPosition).isGreaterThan(4);
    }
}
