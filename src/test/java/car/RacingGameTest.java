package car;

import car.domain.GameResult;
import car.domain.RacingGame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private static final String[] CAR_NAMES = {"test1", "test2", "test3"};
    private static final int RACING_COUNT = 5;
    private RacingGame racingGame;

    @Before
    public void setUp(){
        racingGame = new RacingGame(CAR_NAMES, RACING_COUNT);
        racingGame.playingGame();
    }

    @Test
    public void 초기화_된_CAR_COUNT로_GAME_SETTING_성공() {
        GameResult gameResult = racingGame.playingGame();
        assertThat(gameResult.getRoundResult().size()).isEqualTo(CAR_NAMES.length);
    }
}
