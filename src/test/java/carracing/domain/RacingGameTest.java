package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("RacingGame Constructor Test")
    public void constructorTest() {
        RacingGame racingGame = new RacingGame(3, 5);
        assertThat(racingGame.getCarList().size()).isEqualTo(3);
        /* tryCount setting 됐는지 Test를 할 방법을 모르겠다.
        - comparingOnlyFields : partial test가 안된다.
        assertThat(racingGame)
                .usingRecursiveComparison()
                .comparingOnlyFields("carList","tryCount")
                .isEqualTo(new RacingGame(3,5));
         */
    }

    @Test
    @DisplayName("Remain TryCount Test")
    public void remainTryCountTest() {
        RacingGame racingGame = new RacingGame(3, 2);
        assertThat(racingGame.remainTryCount()).isTrue();
        racingGame = new RacingGame(3, 0);
        assertThat(racingGame.remainTryCount()).isFalse();
    }

    @Test
    @DisplayName("Reduce TryCount Test")
    public void reduceTryCountTest() {
        RacingGame racingGame = new RacingGame(3, 2);
        racingGame.reduceTryCount();
        assertThat(racingGame)
                .usingRecursiveComparison()
                .comparingOnlyFields("carList", "tryCount")
                .isEqualTo(new RacingGame(3, 1));
    }


    @Test
    @DisplayName("Racing Test")
    public void racingTest() {
        RacingGame racingGame = new RacingGame(2, 1);
        Car car1 = racingGame.getCarList().get(0);
        car1.setMovable(5);
        racingGame.racing();
        assertThat(car1.getPosition()).isEqualTo(1);
        car1.setMovable(4);
        racingGame.racing();
        assertThat(car1.getPosition()).isEqualTo(1);
    }
}