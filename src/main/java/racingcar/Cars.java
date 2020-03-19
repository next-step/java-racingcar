package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(InputView inputView) {
        createCars(inputView);
    }

    private void createCars(InputView inputView) {
        int carCount = inputView.getCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveTryCount(InputView inputView, RandomNumGenerator rng) {
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            printTryCount(i);
            moveOnce(rng);
            printCarsAfterMoveOnce();
        }
        printBorderLine();
    }

    private void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println(currentTryCount + 1 + "회차");
    }

    private void moveOnce(RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNum = rng.generateNumberLessThanTen();
            boolean canRun = car.canRun(randomNum);
            car.move(canRun);
        }
    }

    private void printCarsAfterMoveOnce() {
        cars.stream()
                .forEach(it -> it.printPosition());
    }

    private void printBorderLine() {
        System.out.println("=====================================");
    }
}