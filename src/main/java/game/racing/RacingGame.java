package game.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;
    private Random random;
    private int tryCount;

    public void start() {
        try(RacingGameReader racingGameReader = new RacingGameReader(System.in)) {

            init(racingGameReader);
            process();
        }
    }

    private void init(RacingGameReader racingGameReader) {
        String[] carNames = racingGameReader.readCarName();
        this.cars = createCars(carNames);
        this.tryCount = racingGameReader.readTryCount();
        this.random = new Random();
    }

    List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void process() {
        System.out.println("실행 결과");
        printAll();
        for (int i = 0; i < this.tryCount - 1; i++) {
            moveAll();
            printAll();
        }
        printGameResult();
    }


    private void printAll() {
        ResultPrinter.printCurrentState(cars);
        System.out.println();
    }

    private void moveAll() {
        for (Car car : cars) {
            int moveNumber = this.random.nextInt(10);
            car.move(moveNumber);
        }
    }

    private void printGameResult() {
        List<String> winnerNames = findWinnerNames(cars);
        ResultPrinter.printGameResult(winnerNames);
    }

    List<String> findWinnerNames(List<Car> cars) {
        final int maxMoveCount = findMaxMoveCount(cars);

        return cars.stream()
                .filter(car -> car.isSameMoveCount(maxMoveCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }

}
