package game;

import java.util.Scanner;

public class RacingGame {

    private Integer numberOfCar;
    private Integer round;

    public void inputNumberOfCar() {
        try (Scanner sc = new Scanner(System.in)) {
            this.numberOfCar = inputPositiveNumber(sc);
        }
    }

    private static int inputPositiveNumber(Scanner sc) {
        int result = sc.nextInt();
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }

    public int cars() {
        return numberOfCar;
    }

    public void inputNumberOfRound() {
        try (Scanner sc = new Scanner(System.in)) {
            this.round = inputPositiveNumber(sc);
        }
    }

    public int round() {
        return round;
    }
}
