package racing;

import java.util.*;
import racing.strategy.*;

public class RacingGame {
    private List<Car> cars;
    private int moves;

    public RacingGame(int numOfCars, int numOfMoves) {
        setCars(numOfCars);
        setMoves(numOfMoves);
    }

    public void startRacing() {
        Printer.printStartRacing();

        for (int i = 0; i < this.moves; i++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.goOrNot(new DrivingRandomStrategy());
        }

        Printer.printResult(cars);
    }

    private void setCars(int numOfCars) {
        cars = new ArrayList<>(numOfCars);

        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car());
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
