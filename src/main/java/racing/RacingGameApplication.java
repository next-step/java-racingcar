package racing;

import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RacingCreateValueObject;
import racing.dto.RacingGameResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCreateValueObject racingCreateValueObject = inputView.createByUserInput();

        RacingGame racingGame = new RacingGame(racingCreateValueObject, new RandomMovement(new Random()));

        OutputView outPutView = new OutputView();
        outPutView.printGuidance();

        List<RacingGameResult> racingGameResults = null;
        for (int i = 0; i < racingCreateValueObject.getTotalRacingCount(); i++) {
            racingGame.executeRacing();
            racingGameResults = racingGame.calculateRacingGameResults();
            outPutView.printRacingResult(racingGameResults);
        }

        int maxPosition = racingGame.calculateMaxPosition();
        outPutView.printRacingWinners(racingGameResults, maxPosition);
    }
}
