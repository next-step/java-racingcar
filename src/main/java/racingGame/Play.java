package racingGame;

import java.util.List;

public class Play {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        List<String> names = inputView.readCarNames();
        int tryCount = inputView.readTryCount();

        RacingGame game = new RacingGame(names, tryCount, new RandomMoveStrategy());
        List<Round> rounds = game.race();
        List<String> winners = game.winners();

        ResultView resultView = new ResultView();
        resultView.print(rounds, names, winners);
    }
}
