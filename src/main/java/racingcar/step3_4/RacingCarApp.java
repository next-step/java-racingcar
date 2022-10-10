package racingcar.step3_4;

import java.util.Random;
import racingcar.step3_4.domain.Game;
import racingcar.step3_4.domain.GameAttribute;
import racingcar.step3_4.domain.GameRecord;
import racingcar.step3_4.domain.RandomValueGenerator;
import racingcar.step3_4.view.InputView;
import racingcar.step3_4.view.ResultView;

public class RacingCarApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameAttribute gameAttribute = inputView.getGameAttribute();

        Random random = new Random();
        final int LIMIT = 10;
        RandomValueGenerator randomValueGenerator = () -> random.nextInt(LIMIT);
        Game game = new Game(randomValueGenerator);
        GameRecord gameRecord = game.play(gameAttribute);

        ResultView resultView = new ResultView();
        resultView.printGameResult(gameRecord);
    }
}
