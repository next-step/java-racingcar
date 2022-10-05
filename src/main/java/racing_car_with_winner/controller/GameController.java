package racing_car_with_winner.controller;

import racing_car_with_winner.model.CarFactory;
import racing_car_with_winner.model.CarNameInput;
import racing_car_with_winner.model.GameAttemptCount;
import racing_car_with_winner.model.MovableStrategy;
import racing_car_with_winner.model.car.Cars;
import racing_car_with_winner.view.GameDashBoard;
import racing_car_with_winner.view.UserOutputInterface;

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

        do {
            playCount = playCount.play();
            cars = cars.moveCars(movableStrategy);
            cars.getCars().forEach(car -> new GameDashBoard(userOutputInterface).showMoveResult(car.getCarName(), car.getMoveResult()));
        } while(!playCount.isEnded());

        new GameDashBoard(userOutputInterface).showWinner(cars.findWinner());
    }
}
