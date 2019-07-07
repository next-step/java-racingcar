package racing.domain;

import racing.domain.strategy.DrivingRandomStrategy;
import racing.view.Printer;

import java.util.List;

public class RacingGame {
    private Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public void startRacing(int moves) {
        Printer.printStartRacing();

        for (int i = 0; i < moves; i++) {
            move();
        }

        Printer.printEndGame(new WinnerMaker(cars).getWinners());
    }

    private void move() {
        cars.go(new DrivingRandomStrategy());

        Printer.printResult(cars);
    }

    public int getNumOfCars() {
        return cars.size();
    }
}