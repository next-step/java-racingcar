package racingcar.winner.controller;

import racingcar.winner.model.CarFactory;
import racingcar.winner.model.Cars;
import racingcar.winner.model.GameAttemptCount;
import racingcar.winner.model.RacingGame;
import racingcar.winner.view.CarNameInput;
import racingcar.winner.view.MoveResultView;
import racingcar.winner.view.UserOutputInterface;
import racingcar.winner.view.WinnerView;

public class GameController {
    private final UserOutputInterface userOutputInterface;

    public GameController(UserOutputInterface userOutputInterface) {
        this.userOutputInterface = userOutputInterface;
    }

    public void play(CarNameInput carNameInput, GameAttemptCount gameAttemptCount) {
        RacingGame racingGame = new RacingGame(new Cars(new CarFactory(carNameInput.parse()).build()), gameAttemptCount);

        userOutputInterface.show("실행결과\n");

        do {
            racingGame = racingGame.play();
            racingGame.getCars().stream()
                .map(car -> new MoveResultView(car.getCarName(), car.getMoveResult()).getMessage())
                .forEach(userOutputInterface::show);

            userOutputInterface.show("\n");
        } while(!racingGame.isGameEnded());

        userOutputInterface.show(new WinnerView(racingGame.findWinner()).getMessage());
    }
}
