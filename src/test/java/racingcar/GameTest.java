package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5"})
    public void 게임플레이(int carCount, int roundCount){
        System.out.println(carCount);
        System.out.println(roundCount);
        InputView.viewCountCarInputMessage();
        Game.setCars(carCount);

        InputView.viewCoutRoundInputMessage();
        Game.setRoundCount(roundCount);

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            Game.playRound();
        }

    }
}
