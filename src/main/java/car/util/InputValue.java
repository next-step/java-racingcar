package car.util;

import java.util.Scanner;

public class InputValue {
    private static Scanner scanner;

    public static int getCarCount() {
        scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");

        int num = scanner.nextInt();
        return num;
    }

    public static int getTryCount() {
        scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");

        int num = scanner.nextInt();
        return num;
    }
}
