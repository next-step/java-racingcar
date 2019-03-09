package racingcar;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class RacingGameTest {

    @Test
    public void RacingGame_생성_시_자동차_셋업() {
        int numberOfCar = 3;
        RacingGame racingGame = new RacingGame(numberOfCar);
        Car[] cars = racingGame.getCars();

        assertThat(cars)
                .hasSize(numberOfCar)
                .doesNotContain((Car) null);
    }

    @Test
    public void 레이스_종료_후_움직인거리가_시도횟수보다_크면_안됨() {
        int numberOfCar = 3;
        int tryCount = 5;

        RacingGame racingGame = new RacingGame(numberOfCar);
        racingGame.start(tryCount);

        Car[] cars = racingGame.getCars();

        Arrays.stream(cars)
                .forEach(car -> {
                    assertThat(car.getMovedDistance()).isLessThanOrEqualTo(tryCount);
                });
    }
}