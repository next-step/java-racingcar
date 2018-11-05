package racing_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private List<Car> cars;
    private int tryCount;
    private Random random;

    public void start() {
        try(Scanner scanner = new Scanner(System.in)) {
            init(scanner);
            process();
        }
    }

    private void init(Scanner scanner) {
        int carCount = readCarCount(scanner);
        this.cars = createCars(carCount);
        this.tryCount = readTryCount(scanner);
        this.random = new Random();
    }

    int readCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    int readTryCount(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
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
            StringBuilder sb = new StringBuilder(car.getMoveCount());
            for (int i = 0; i < car.getMoveCount(); i++) {
                sb.append("-");
            }
            System.out.println(sb.toString());
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
