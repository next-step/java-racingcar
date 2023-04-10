package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {
    private final List<Car> cars = new ArrayList<>();
    private final Random random = new Random();
    private final Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        InputView.printCarsCountInputMessage();
        int carsCount = inputCount();
        InputView.printTryCountInputMessage();
        int tryCount = inputCount();
        createCars(carsCount);
        ResultView.printResultHeader();
        play(tryCount);
    }

    public int inputCount() {
        String countString = scanner.nextLine();
        int count = Integer.parseInt(countString);
        isPositive(count);
        return count;
    }

    private void isPositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(String.format("음수는 입력할 수 없습니다. input: %d", count));
        }
    }

    private void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            move();
            view();
        }
    }

    private void view() {
        for (Car car : cars) {
            car.view();
        }
        System.out.println();
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void createCars(int carsCount) {
        for (int i = 0; i < carsCount; i++) {
            cars.add(new Car(random));
        }
    }

    // 해당 메소드도 테스트 코드만을 위해서 만들었습니다!
    public boolean hasCars(int expected) {
        return cars.size() == expected;
    }
}
