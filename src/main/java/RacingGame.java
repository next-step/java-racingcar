import model.Car;
import model.CarName;
import model.GameResult;
import service.GameStrategy;
import service.WinnerStrategy;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private final List<Car> cars = new ArrayList();

    private final GameStrategy gameStrategy;
    private final WinnerStrategy winnerStrategy;

    public RacingGame(GameStrategy gameStrategy, WinnerStrategy winnerStrategy, List<CarName> carNames) {
        this.gameStrategy = gameStrategy;
        this.winnerStrategy = winnerStrategy;
        for (CarName carName : carNames) {
            this.cars.add(Car.carWithName(carName));
        }
    }

    public GameResult play() {
        for (Car car : this.cars) {
            this.moveCarByStrategy(car);
        }
        return new GameResult(cars);
    }

    void moveCarByStrategy(Car car) {
        if (!this.gameStrategy.isCarMove()) {
            return;
        }
        car.move();
    }

    public GameResult getWinners() {
        return new GameResult(this.winnerStrategy.pickWinner(this.cars));
    }

}
