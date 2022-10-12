package racingcar.winner;

import racingcar.winner.controller.GameController;
import racingcar.winner.view.CarNameInput;
import racingcar.winner.model.GameAttemptCount;
import racingcar.winner.model.RandomMovableStrategy;
import racingcar.winner.view.CarNameInputInterface;
import racingcar.winner.view.ConsoleUserInputInterface;
import racingcar.winner.view.ConsoleUserOutputInterface;
import racingcar.winner.view.GameAttemptCountInputInterface;

public class GameDispatcher {

    public static void main(String[] args) {
        CarNameInput carNameInput = new CarNameInput(new CarNameInputInterface(new ConsoleUserInputInterface()).getInput());
        GameAttemptCount gameAttemptCount = new GameAttemptCount(new GameAttemptCountInputInterface(new ConsoleUserInputInterface()).getInput());

        new GameController(new ConsoleUserOutputInterface()).play(carNameInput, gameAttemptCount);
    }
}
