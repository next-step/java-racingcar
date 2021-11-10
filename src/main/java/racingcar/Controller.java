package racingcar;

import racingcar.collection.RaceResult;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameRequest request = inputView.inputRacingGame();

        RacingGame game = new RacingGame(request, new RandomMoveStrategy());
        RaceResult raceResult = game.playRace();

        outputView.printRaceHistories(raceResult);
    }
}
