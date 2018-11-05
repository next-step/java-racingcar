package racinggame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;
    private static final int CAR_COUNT = 3;
    private static final int RACE_TIME = 5;

    @Before
    public void setUp() {
        racingGame = new RacingGame(CAR_COUNT, RACE_TIME);
    }

    @Test
    public void 경기_완료() {
        for(int i = 0; i < RACE_TIME; i++) {
            racingGame.raceOneTime();
        }

        int[] racingResult = racingGame.getCarPosition();

        for(int i = 0; i< racingResult.length; i++) {
            assertThat(racingResult[i]).isGreaterThanOrEqualTo(0);
            assertThat(racingResult[i]).isLessThanOrEqualTo(5);
        }
    }

    @Test
    public void 레이스_경기_1회_시도() {
        int[] carPosition = racingGame.raceOneTime();

        for(int i = 0; i< carPosition.length; i++) {
            assertThat(carPosition[i]).isLessThanOrEqualTo(1);
        }
    }
    @Test
    public void 첫번째_세번째_자동차_움직임_시도() {
        racingGame.moveCar(0);
        racingGame.moveCar(2);

        int[] carPosition = racingGame.getCarPosition();

        assertThat(carPosition[0]).isLessThanOrEqualTo(1);
        assertThat(carPosition[2]).isLessThanOrEqualTo(1);

    }

    @Test
    public void 자동차_움직임_가능여부_테스트() {
        boolean canMove = racingGame.isCarMove(5);
        boolean canNotMove = racingGame.isCarMove(1);

        assertThat(canMove).isTrue();
        assertThat(canNotMove).isFalse();

    }
}