package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static int MOVE_FLAG = 4;
    private int numberofCars;
    private int numberofAttempts;
    private List<Integer> cars;

    public RacingGame() {

    }

    public RacingGame(int numberofCars, int numberofAttempts) {
        this.numberofCars = numberofCars;
        this.numberofAttempts = numberofAttempts;
    }

    public void startGame() {
        InputView.inputData(numberofCars, numberofAttempts);
        initCars();
        processGame();
        printCars();
    }

    private void initCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < numberofCars; i++) {
            cars.add(0);
        }
    }

    private void processGame() {
        for (int i = 0; i < numberofAttempts; i++) {
            carMoves();
        }
    }

    private void printCars() {
        for (int i = 0; i < numberofCars; i++) {
            OutputView.printData(cars.get(i));
            System.out.println();
        }
    }

    private void carMoves() {
        for (int i = 0; i < numberofCars; i++) {
            if (isMove(getRandomValue())) {
                int movingCount = cars.get(i);
                cars.set(i, ++movingCount);
            }
        }
    }

    boolean isMove(int randomValue) {
        if (MOVE_FLAG <= randomValue) {
            return true;
        }
        return false;
    }

    int getRandomValue() {
        return new Random().nextInt(10);
    }
}
