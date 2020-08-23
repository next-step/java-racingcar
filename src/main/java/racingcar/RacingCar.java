package racingcar;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private static int carNumber;
    private static int round;

    public static void main(String[] args) {
        inputView();

        String[] cars = new String[carNumber];
        Arrays.fill(cars, "");

        resultView(cars);
    }

    private static void inputView() {
        carNumber = getCarNumber();
        round = getRoundNumber();
    }

    private static int getCarNumber() {
        System.out.println(Constants.INPUT_CAR_NUMBER_COMMANDS);
        return input();
    }

    private static int getRoundNumber() {
        System.out.println(Constants.INPUT_ROUND_NUMBER_COMMANDS);
        return input();
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void resultView(String[] cars) {
        System.out.println(Constants.RESULT_MESSAGE);
        Random rand = new Random();

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < carNumber; j++) {
                int randomNumber = rand.nextInt(10);
                if (randomNumber >= 4) {
                    cars[j] += "-";
                }
                System.out.println(cars[j]);
            }
            System.out.println();
        }
    }

}
