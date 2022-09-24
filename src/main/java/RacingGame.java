import model.Car;
import model.GameResult;
import service.GameStrategy;
import service.WinnerStrategy;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private final List<Car> cars = new ArrayList();

    private final GameStrategy gameStrategy;
    private final WinnerStrategy winnerStrategy;

    public RacingGame(GameStrategy gameStrategy , WinnerStrategy winnerStrategy, String[] carNames) {
        this.gameStrategy = gameStrategy;
        this.winnerStrategy = winnerStrategy;
        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(Car.carWithName(carNames[i]));
        }
    }

    public GameResult play() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            moveCarByStrategy(car);
        }
        return new GameResult(cars);
    }

    void moveCarByStrategy(Car car) {
        if (!this.gameStrategy.isCarMove()) {
            return;
        }
        car.move();
    }

    public GameResult getWinners(){
       return new GameResult(this.winnerStrategy.pickWinner(this.cars));
    }

}
