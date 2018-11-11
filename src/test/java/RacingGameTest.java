import org.junit.Test;
import racingGame.RacingGame;

public class RacingGameTest {
    @Test
    public void 레이싱게임() {
        RacingGame racingGame1 = new RacingGame();
        String[] carNames1 = {"소나타", "K5", "SM6", "말리부"};
        racingGame1.gameStart(carNames1, 5);

        RacingGame racingGame2 = new RacingGame();
        String[] carNames2 = {"BMW", "벤츠"};
        racingGame2.gameStart(carNames2, 3);
    }
}
