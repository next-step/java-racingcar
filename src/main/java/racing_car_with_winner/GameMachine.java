package racing_car_with_winner;

import racing_car_with_winner.controller.GameController;
import racing_car_with_winner.model.CarNameInput;
import racing_car_with_winner.model.GameAttemptCount;
import racing_car_with_winner.model.RandomMovableStrategy;
import racing_car_with_winner.view.CarNameInputInterface;
import racing_car_with_winner.view.ConsoleUserInputInterface;
import racing_car_with_winner.view.ConsoleUserOutputInterface;
import racing_car_with_winner.view.GameAttemptCountInputInterface;

public class GameMachine {

    public static void main(String[] args) {
        CarNameInput carNameInput = new CarNameInput(new CarNameInputInterface(new ConsoleUserInputInterface()).getInput());
        GameAttemptCount gameAttemptCount = new GameAttemptCount(new GameAttemptCountInputInterface(new ConsoleUserInputInterface()).getInput());

        new GameController(new RandomMovableStrategy(), new ConsoleUserOutputInterface()).play(carNameInput, gameAttemptCount);
    }
}
