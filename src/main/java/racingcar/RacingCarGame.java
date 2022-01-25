package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private final static Random RANDOM = new Random();
    private final List<Car> cars = new ArrayList<>();
    private final List<String> carNames;
    private final List<Integer> racingResults = new ArrayList<>();
    private List<String> winners;
    private int tryCount;

    public RacingCarGame(int tryCount, List<String> carNames) {
        this.tryCount = tryCount;
        this.carNames = carNames;
        initializeCar();
    }

    private int getRandomMove() {
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

    private boolean checkMovable(int move) {
        return MOVABLE <= move;
    }

    public void playRacingCarGame() {
        System.out.println("실행 결과");

        do {
            controlRacingCar();

            tryCount--;

        } while (tryCount > 0);

        printGameResult();
    }

    private void controlRacingCar() {
        for (int i = 0; i < racingCarList.size(); ++i) {
            int move = getRandomMove();

            setRacingResults(i, move);
        }
    }

    private void setRacingResults(int carNumber, int move) {
        if (!checkMovable(move)) {
            printMoveState(carNumber);
            return;
        }

        racingResults[carNumber] += "-";
        printMoveState(carNumber);
    }

    private void printMoveState(int carNumber) {
        System.out.println(racingCarList.get(carNumber) + " : " + racingResults[carNumber]);

        if (carNumber == racingCarList.size() - 1) {
            System.out.println();
        }
    }

    private void printGameResult() {
        int maxMove = Arrays.stream(racingResults).mapToInt(String::length).max().getAsInt();

        for (int i = 0; i < racingResults.length; ++i) {
            setRacingWinners(i, maxMove);
        }

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private void setRacingWinners(int i, int maxMove) {
        if (racingResults[i].length() == maxMove) {
            winners.add(racingCarList.get(i));
        }
    }
}
