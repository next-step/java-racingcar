package racingcar.winner.controller;

import racingcar.winner.model.CarFactory;
import racingcar.winner.model.Cars;
import racingcar.winner.model.GameAttemptCount;
import racingcar.winner.model.RandomMovableStrategy;
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
        Cars cars = new Cars(new CarFactory(carNameInput.parse()).build());
        GameAttemptCount playCount = gameAttemptCount;

        userOutputInterface.show("실행결과\n");

        do {
            playCount = playCount.play();

            cars = cars.moveCars(new RandomMovableStrategy());

            cars.getCars().stream()
                .map(car -> new MoveResultView(car.getCarName(), car.getMoveResult()).getMessage())
                .forEach(userOutputInterface::show);

            userOutputInterface.show("\n");
        } while(!playCount.isEnded());

        userOutputInterface.show(new WinnerView(cars.findWinner()).getMessage());
    }
}
