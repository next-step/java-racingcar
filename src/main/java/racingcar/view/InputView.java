package racingcar.view;

import commons.Constant;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String inputNumberOfCars() {
        System.out.println(Constant.NUMBER_OF_CARS_PROMPT);
        return scanner.nextLine();
    }

    public static String inputNumberOfAttempts() {
        System.out.println(Constant.RACING_TIMES_PROMPT);
        return scanner.nextLine();
    }
}
