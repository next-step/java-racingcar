package racingcar;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 초기화() {
        int numberOfCar = 3;
        RacingGame game = new RacingGame(numberOfCar);

        assertThat(game.getNumberOfCars()).isEqualTo(numberOfCar);
    }

    @Test
    public void 게임하기() {
        int time = 5;
        int numberOfCar = 3;
        RacingGame game = new RacingGame(numberOfCar);
        GameResult result = game.play(time);

        assertThat(result.countRoundLength()).isEqualTo(time);
    }


    @Test
    public void 이동_후_자동차_위치정보_추출() {
        int numberOfCar = 3;
        RacingGame game = new RacingGame(numberOfCar);
        List<Integer> positions = game.positionsAfterCarsMove(game.getCars());

        assertThat(positions.size()).isEqualTo(numberOfCar);
    }


}