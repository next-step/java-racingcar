package racing;

import java.util.*;
import java.util.stream.Collectors;

import racing.strategy.*;

public class RacingGame {
    private Cars cars;
    private int moves;

    public RacingGame(List<String> carNames, int numOfMoves) {
        this.cars = new Cars(carNames);
        this.moves = numOfMoves;
    }

    public void startRacing() {
        Printer.printStartRacing();

        for (int i = 0; i < this.moves; i++) {
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

    public int getNumOfMove() {
        return this.moves;
    }
}