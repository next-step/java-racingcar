package racing.controller;

import racing.model.Cars;
import racing.model.RaceGame;
import racing.model.Round;
import racing.view.ResultView;

public class RaceController {
    private final RaceGame game;
    private final Round round;

    public RaceController(Cars cars, int roundCount) {
        this(new RaceGame(cars), new Round(roundCount));
    }

    public RaceController(RaceGame game, Round round) {
        this.game = game;
        this.round = round;
    }

    public void start() {
        ResultView.printResultHeader();
        while (round.isPlaying()) {
            playRound();
            round.decreaseRemainingCount();
        }
        ResultView.printWinners(game.getWinners());
    }

    private void playRound() {
        game.race();
        ResultView.printResult(game);
    }
}
