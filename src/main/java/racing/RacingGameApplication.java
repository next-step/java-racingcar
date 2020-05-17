package racing;

import racing.domain.PositionWinner;
import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInformation raceInformation = inputView.createByUserInput();

        RacingGame racingGame = new RacingGame(raceInformation, new RandomMovement(new Random()), new PositionWinner());
        List<RacingGameResult> racingGameResults = racingGame.executeRacing();

        OutputView outPutView = new OutputView();
        outPutView.printGuidance();
        outPutView.printRacingResult(racingGameResults);
        outPutView.printRacingWinners(racingGame.calculateWinners());
    }
}
