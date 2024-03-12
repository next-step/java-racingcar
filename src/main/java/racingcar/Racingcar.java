package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.*;
import java.util.stream.IntStream;

public class Racingcar {
    private static final int RANDOM_VALUE = 10;
    private static final int MOVE_CONDITION = 3;
    private static final int MAX_INPUT_VALUE = 10000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCar = inputNumberOfCar(scanner);
        int numberOfAttempt = inputNumberOfAttempt(scanner);

        if (!isMaximumInput(numberOfCar, numberOfAttempt)) {
            gameLogic(numberOfCar, numberOfAttempt);
        }
    }

    public static boolean isMaximumInput(int numberOfCar, int numberOfAttempt) {
        if(numberOfCar > MAX_INPUT_VALUE && numberOfAttempt > MAX_INPUT_VALUE)
            return true;
        return false;
    }

    public static void gameLogic(int numberOfCar, int numberOfAttempt) {
        List<Car> carList = initCarList(numberOfCar);
        IntStream.range(0, numberOfAttempt).forEach(i -> moveCarList(carList));
    }

    private static void moveCarList(List<Car> carList) {
        carList.stream().forEach(car -> {
            car.move(isMovingForward(getRandomValue()));
            ResultView.getInstance().printMove(car);
        });
        ResultView.getInstance().printLineBreak();
    }

    private static List<Car> initCarList(int numberOfCar) {
        List<Car> carList = new ArrayList<>(numberOfCar);
        IntStream.range(0, numberOfCar).forEach(i -> carList.add(new Car()));
        return carList;
    }

    public static boolean isMovingForward(int value) {
        return value > MOVE_CONDITION;
    }

    public static int getRandomValue() {
        int randomValue = random.nextInt(RANDOM_VALUE);
        return randomValue;
    }

    private static int inputNumberOfCar(Scanner scanner) {
        InputView.getInstance().printNumberOfCar();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수 타입이 아닙니다!" + e);
            throw new RuntimeException();
        }
    }

    private static int inputNumberOfAttempt(Scanner scanner) {
        InputView.getInstance().printNumberOfAttempt();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수 타입이 아닙니다!" + e);
            throw new RuntimeException();
        }
    }
}
