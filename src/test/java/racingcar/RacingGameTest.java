package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차_셋업() {
        RacingGame racingGame = new RacingGame();
        int numberOfCar = 3;

        Car[] cars = racingGame.carSetUp(numberOfCar);

        assertThat(cars.length).isEqualTo(3);

        for (int i = 0, loop = cars.length; i < loop; i++) {
            assertThat(cars[i].getMovedDistance()).isEqualTo(0);
        }
    }

    @Test
    public void 레이스_종료_후_움직인거리가_시도횟수보다_크면_안됨() {
        RacingGame racingGame = new RacingGame();
        int numberOfCar = 3;
        int tryCount = 5;

        Car[] cars = racingGame.carSetUp(numberOfCar);
        racingGame.start(tryCount);

        for (int i = 0; i < numberOfCar; i++) {
            assertThat(cars[i].getMovedDistance()).isLessThanOrEqualTo(tryCount);
        }
    }

}