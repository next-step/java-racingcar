package racing_car_with_winner.controller;

import racing_car_with_winner.model.CarFactory;
import racing_car_with_winner.model.CarNameInput;
import racing_car_with_winner.model.GameAttemptCount;
import racing_car_with_winner.model.MovableStrategy;
import racing_car_with_winner.model.car.Cars;
import racing_car_with_winner.view.MoveResultView;
import racing_car_with_winner.view.UserOutputInterface;
import racing_car_with_winner.view.WinnerView;

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
