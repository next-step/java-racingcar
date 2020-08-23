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


}
