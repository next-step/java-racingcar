package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private String[] carNames = {"seo", "yeong", "sy"};
    private int tryNo = 3;

    @Test

    public void 무조건_모든차량_이동() {
        RacingGame racingGame = new RacingGame(new CarMovableAlwaysTrueDecider(), new RacingGameState(carNames, tryNo));
        racingGame.race();
        RacingGameState racingGameState = racingGame.getRacingGameState();
        for (Car car : racingGameState.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 모든_차량_이동안함() {
        RacingGame racingGame = new RacingGame(new CarMovableAlwaysFalseDecider(), new RacingGameState(carNames, tryNo));
        racingGame.race();
        RacingGameState racingGameState = racingGame.getRacingGameState();

        for (Car car : racingGameState.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
