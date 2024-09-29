package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private List<RacingCar> racingCars;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private static int MOVE_CONDITION_NUMBER = 4;
    private int raceCount = 0;

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();
        game.inputView.closeScanner();
    }
    public RacingCarGame() {
        readyCarRacing();
        startRace();
    }

    private void readyCarRacing() {
        int carCount = inputView.receiveCarCount();

        racingCars = new ArrayList<>(carCount);

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }

        this.raceCount = inputView.receiveRaceCount();
    }

    private void startRace() {
        IntStream.range(0, raceCount).forEach(i -> race());
    }
    private void race() {
        for (RacingCar car : racingCars) {
            if (isMovable(NumberUtil.getRandomInt())) {
                car.moveForward();
            };
        }
        printResult();
    }

    private void printResult() {
        resultView.printRaceCondition(racingCars);
    }
}
