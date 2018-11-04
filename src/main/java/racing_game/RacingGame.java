package racing_game;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final String CAR_STRING = "-";
    private StringBuilder[] cars;
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

    StringBuilder[] createCars(int carCount) {
        StringBuilder[] cars = new StringBuilder[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new StringBuilder();
            cars[i].append(CAR_STRING);
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
        for (StringBuilder car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(StringBuilder car) {
        System.out.println(car.toString());
    }

    private void moveAll() {
        for (StringBuilder car : cars) {
            int moveNumber = this.random.nextInt(10);
            move(car, moveNumber);
        }
    }

    void move(StringBuilder car, int moveNumber) {
        if(isMove(moveNumber)) {
            car.append("-");
        }
    }

    boolean isMove(int number) {
        if(number < 0 || number > 9) {
            throw new IllegalArgumentException("숫자는 0 ~ 9 범위여야 합니다.");
        }

        return number >= 4;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }

}
