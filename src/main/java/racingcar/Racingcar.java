package racingcar;

import racingcar.ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Racingcar {
    private static final int RANDOM_VALUE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gameLogic(inputNumberOfCar(scanner), inputNumberOfAttempt(scanner));
    }

    public static void gameLogic(int numberOfCar, int numberOfAttempt) {
        List<Car> carList = initCarList(numberOfCar);

        carList.stream().forEach(car -> IntStream.range(0, numberOfAttempt).forEach(i -> car.addMoveHistory(isMovingForward(getRandomValue()))));
    }

    private static void moveCar(Car car) {
        if (isMovingForward(getRandomValue())) {
            car.move();
        }
    }

    private static List<Car> initCarList(int numberOfCar) {
        List<Car> carList = new ArrayList<>(numberOfCar);
        IntStream.range(0,numberOfCar).forEach(i -> carList.add(new Car()));
        return carList;
    }

    public static boolean isMovingForward(int value) {
        return value > 3;
    }

    public static int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(RANDOM_VALUE);
        return randomValue;
    }

    private static int inputNumberOfCar(Scanner scanner) {
        InputView.getInstance().printNumberOfCar();
        return scanner.nextInt();
    }

    private static int inputNumberOfAttempt(Scanner scanner) {
        InputView.getInstance().printNumberOfAttempt();
        return scanner.nextInt();
    }

}
