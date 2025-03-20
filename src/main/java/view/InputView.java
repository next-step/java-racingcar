package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberOfCars() {
        return getInput("자동차 대수는 몇 대 인가요?");
    }

    public static int getNumberOfRounds() {
        return getInput("시도할 회수는 몇 회 인가요?");
    }

    private static int getInput(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}