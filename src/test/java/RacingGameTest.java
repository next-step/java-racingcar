import org.junit.Test;
import racingGame.RacingGame;

public class RacingGameTest {
    @Test
    public void 레이싱게임() {
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart(3, 5);
    }

}
