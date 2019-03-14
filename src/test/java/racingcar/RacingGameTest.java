package racingcar;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 레이싱_게임_차량_초기화() {
        int carNumber = 4;
        RacingGame racingGame = new RacingGame(carNumber);

        assertThat(racingGame.getCarPositions()).hasSize(carNumber);
    }

    @Test
    public void 모든_차량_이동() {
        int carNumber = 3;
        RacingGame racingGame = new RacingGame(carNumber);
        List<Car> carPositions = racingGame.move(new RandomUtil(4,9));

        for(Car car : carPositions) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 모든_차량_이동안함() {
        int carNumber = 3;
        RacingGame racingGame = new RacingGame(carNumber);
        List<Car> carPositions = racingGame.move(new RandomUtil(0,3));

        for(Car car : carPositions) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
