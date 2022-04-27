package RacingCar.views;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대인가요?");

        return scanner.nextLine();
    }

    public static String askNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return scanner.nextLine();
    }
}
