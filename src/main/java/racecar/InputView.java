package racecar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;
    private InputView() {
    }

    public static int askNumberCount() {
        scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        return carCount;
    }

    public static int askRepeatCount() {
        scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int repeatCount = scanner.nextInt();
        return repeatCount;
    }

}
