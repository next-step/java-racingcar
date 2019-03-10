package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 초기화() {
        int time = 5;
        int numberOfCar = 3;
        RacingGame game = new RacingGame(time, numberOfCar);

        assertThat(game.getNumberOfCars()).isEqualTo(numberOfCar);
        assertThat(game.getTime()).isEqualTo(time);
    }

    @Test
    public void 게임하기() {
        int time = 5;
        int numberOfCar = 3;
        RacingGame game = new RacingGame(time, numberOfCar);
        game.play();
    }
}