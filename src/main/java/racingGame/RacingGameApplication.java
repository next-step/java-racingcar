package racingGame;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> names = inputView.readCarNames();
        int tryCount = inputView.readTryCount();

        RacingGame game = new RacingGame(names, tryCount, new RandomMoveStrategy());
        List<Round> rounds = game.race();
        List<String> winners = game.winners();

        resultView.print(rounds, names, winners);
    }

}
