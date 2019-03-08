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
    public void 자동차_전진() {
        RacingGame racingGame = new RacingGame();
        int numberOfCar = 3;

        Car[] cars = racingGame.carSetUp(numberOfCar);

        // 1회 전진
        racingGame.run(cars);

        for (int i = 0, loop = cars.length; i < loop; i++) {
            assertThat(cars[i].getMovedDistance())
                    .isLessThanOrEqualTo(1);
        }

        // 2회 전진
        racingGame.run(cars);

        for (int i = 0, loop = cars.length; i < loop; i++) {
            assertThat(cars[i].getMovedDistance())
                    .isLessThanOrEqualTo(2);
        }
    }

}