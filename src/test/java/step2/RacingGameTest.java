package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
/*
    @Test
    @DisplayName("자동차 레이싱")
    void moveTest() {
        int carNumber = 4;
        RacingGame racingGame = new RacingGame();
        racingGame.carPositionsInit(carNumber);

        List<CarDto> carPositionList = racingGame.move();
        int sumCarPosition = carPositionList.stream().reduce(0, (a, b) -> a + b);
        assertThat(sumCarPosition).isEqualTo(4);

        carPositionList = racingGame.move();
        sumCarPosition = carPositionList.stream().reduce(0, (a, b) -> a + b);
        assertThat(sumCarPosition).isGreaterThan(4);
    }
*/
    @Test
    @DisplayName("랜덤 숫자에 따른 자동차 움직임 테스트")
    void carPositionUpdateValueTest() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(10);

        RacingGame racingGame = new RacingGame();
        int moveNumber = racingGame.carPositionUpdateValue(randomNumber);

        assertThat(randomNumber > 3).isEqualTo(moveNumber == 1);
        assertThat(randomNumber < 4).isEqualTo(moveNumber == 0);
    }
}
