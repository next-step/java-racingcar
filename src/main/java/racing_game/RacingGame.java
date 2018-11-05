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
        try(CountReader countReader = new CountReader(System.in);
            ResultPrinter resultPrinter = new ResultPrinter(System.out);) {

            init(countReader, resultPrinter);
            process();
        }
    }

    private void init(CountReader countReader, ResultPrinter resultPrinter) {
        int carCount = countReader.readCarCount();
        this.cars = createCars(carCount);
        this.tryCount = countReader.readTryCount();
        this.resultPrinter = resultPrinter;
        this.random = new Random();
    }

    List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
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
    }

    private void printAll() {
        for (Car car : cars) {
            resultPrinter.print(car.getMoveCount());
        }
        System.out.println();
    }

    private void moveAll() {
        for (Car car : cars) {
            int moveNumber = this.random.nextInt(10);
            car.move(moveNumber);
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }

}
