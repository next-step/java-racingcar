import java.util.Random;
import java.util.stream.IntStream;

public class RacingCarGame {
    private RacingCar[] racingCars;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private static int MOVE_CONDITION_NUMBER = 4;

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
        inputView.receiveCarCount();

        int carCount = inputView.getCarCount();

        racingCars = new RacingCar[carCount];
        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new RacingCar();
        }

        inputView.receiveMoveCount();
    }

    private void startRace() {
        IntStream.range(0, inputView.getMoveCount()).forEach(i -> race());
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
