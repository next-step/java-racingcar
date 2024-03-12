package racingcar;

import racingcar.ui.InputView;

import java.util.Random;
import java.util.Scanner;

public class Racingcar {
    private static final int RANDOM_VALUE = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCar = inputNumberOfCar(scanner);
        int numberOfAttempt = inputNumberOfAttempt(scanner);
    }

    private static int inputNumberOfCar(Scanner scanner) {
        InputView.getInstance().printNumberOfCar();
        return scanner.nextInt();
    }

    private static int inputNumberOfAttempt(Scanner scanner) {
        InputView.getInstance().printNumberOfAttempt();
        return scanner.nextInt();
    }

    public static int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(RANDOM_VALUE);
        return randomValue;
    }
}
