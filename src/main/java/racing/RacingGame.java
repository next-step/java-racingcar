package racing;

import java.util.*;
import racing.strategy.*;

public class RacingGame {
    private List<Car> cars;
    private int moves;

    public RacingGame(List<String> carNames, int numOfMoves) {
        setCars(carNames);
        setMoves(numOfMoves);
    }

    public void startRacing() {
        Printer.printStartRacing();

        for (int i = 0; i < this.moves; i++) {
            move();
        }

        Printer.printEndGame(new WinnerMaker(cars).getWinners());
    }

    private void move() {
        for (Car car : cars) {
            car.goOrNot(new DrivingRandomStrategy());
        }

        Printer.printResult(cars);
    }

    private void setCars(List<String> carNames) {
        cars = new ArrayList<>(carNames.size());

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public int getNumOfCars() {
        return cars.size();
    }

    private void setMoves(int numOfMoves) {
        this.moves = numOfMoves;
    }

    public int getNumOfMove() {
        return this.moves;
    }
}
