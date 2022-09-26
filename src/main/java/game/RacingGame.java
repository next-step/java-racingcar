package game;

import java.util.Scanner;

public class RacingGame {

    private Integer numberOfCar;
    private Integer round;

    public void inputNumberOfCar() {
        this.numberOfCar = inputPositiveNumber();
    }

    public void inputNumberOfRound() {
        this.round = inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        try (Scanner sc = new Scanner(System.in)) {
            int result = sc.nextInt();
            checkPositiveNumber(result);
            return result;
        }
    }

    private static void checkPositiveNumber(int result) {
        if (result < 0) {
            throw new RuntimeException();
        }
    }

    public int cars() {
        return numberOfCar;
    }

    public int round() {
        return round;
    }
}
