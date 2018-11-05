package racing_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private ResultPrinter resultPrinter;
    private Random random;
    private int tryCount;

    public void start() {
        try(RacingGameReader racingGameReader = new RacingGameReader(System.in);
            ResultPrinter resultPrinter = new ResultPrinter(System.out);) {


            init(racingGameReader, resultPrinter);
            process();
        }
    }

    private void init(RacingGameReader racingGameReader, ResultPrinter resultPrinter) {
        String[] carNames = racingGameReader.readCarName();
        this.cars = createCars(carNames);
        this.tryCount = racingGameReader.readTryCount();
        this.resultPrinter = resultPrinter;
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
        for (Car car : cars) {
            resultPrinter.printCurrentState(car.getName(), car.getMoveCount());
        }
        System.out.println();
    }

    private void moveAll() {
        for (Car car : cars) {
            int moveNumber = this.random.nextInt(10);
            car.move(moveNumber);
        }
    }

    private void printGameResult() {
        resultPrinter.printGameResult(cars);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }

}
