package racingcar.winner.controller;

import racingcar.winner.model.CarFactory;
import racingcar.winner.view.CarNameInput;
import racingcar.winner.model.GameAttemptCount;
import racingcar.winner.model.MovableStrategy;
import racingcar.winner.model.Cars;
import racingcar.winner.view.MoveResultView;
import racingcar.winner.view.UserOutputInterface;
import racingcar.winner.view.WinnerView;

public class GameController {
    private final MovableStrategy movableStrategy;
    private final UserOutputInterface userOutputInterface;

    public GameController(MovableStrategy movableStrategy, UserOutputInterface userOutputInterface) {
        this.movableStrategy = movableStrategy;
        this.userOutputInterface = userOutputInterface;
    }

    public void play(CarNameInput carNameInput, GameAttemptCount gameAttemptCount) {
        Cars cars = new Cars(new CarFactory(carNameInput).build());
        GameAttemptCount playCount = gameAttemptCount;

        userOutputInterface.show("실행결과\n");

        do {
            playCount = playCount.play();

            cars = cars.moveCars(movableStrategy);

            cars.getCars().stream()
                .map(car -> new MoveResultView(car.getCarName(), car.getMoveResult()).getMessage())
                .forEach(userOutputInterface::show);

            userOutputInterface.show("\n");
        } while(!playCount.isEnded());

        userOutputInterface.show(new WinnerView(cars.findWinner()).getMessage());
    }
}
