package game;

import game.domain.car.RacingGameCarList;
import game.domain.game.RacingGame;
import game.domain.rule.RacingGameRule;
import game.view.output.RacingGameOutput;

import java.util.List;

public class RacingGameController {

    private RacingGame racingGame;

    public RacingGameController(int forwardNumber, int bound, List<String> carNames, int round) {
        this.racingGame = new RacingGame(
                new RacingGameRule(forwardNumber, bound),
                RacingGameCarList.makeRacingGameCars(carNames),
                round);
    }

    public void startGame() {
        RacingGameOutput.startGame();
        for (int i = 0; i < racingGame.round().getRound(); i++) {
            racingGame.progressRound();
            RacingGameOutput.printCarsStatus(racingGame.carList());
            RacingGameOutput.finishRound();
        }
        RacingGameOutput.endGame(racingGame.carList());
    }
}
