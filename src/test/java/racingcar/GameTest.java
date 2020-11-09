package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5"})
    public void 게임플레이(int carCount, int roundCount){

        Game game = new Game();

        InputView.viewCountCarInputMessage();
        System.out.println(carCount);
        game.setCars(carCount);

        InputView.viewCoutRoundInputMessage();
        System.out.println(roundCount);
        Game.setRoundCount(roundCount);

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            game.playRound();
        }
    }
}
