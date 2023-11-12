package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int tryNumber;
    private RacingCar[] cars;

    public void play() {
        int[] inputValues = input();
        makeGame(inputValues);
        int randomValue = getRandomValue();
    }

    private static int[] input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        return new int[] {carNumber, tryNumber};
    }

    private void makeGame(int[] inputValues) {
        validateInput(inputValues);
        this.makeCars(inputValues[0]);
        this.tryNumber = inputValues[1];
    }

    private void makeCars(int carNumber) {
        this.cars = new RacingCar[carNumber];
    }

    public static void validateInput(int[] input) {
        for (int i : input) {
            if (i < 0) {
                throw new RuntimeException("Negative numbers are not allowed.");
            }
        }
    }

    public static int getRandomValue() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
