package game;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void inputData(int numberofCars, int numberofAttempts) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        numberofCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        numberofAttempts = scanner.nextInt();
    }
}
