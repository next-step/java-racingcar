package step3.controller;

import java.util.Scanner;

public class InputController {


    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputController() {}

    public static int putCarCount() {
        System.out.println(CAR_COUNT);
        return getNumber();
    }

    public static int putTryCount() {
        System.out.println(TRY_COUNT);
        return getNumber();

    }

    private static int getNumber() {
        int number = scanner.nextInt();
        System.out.println(number + "");
        return number;
    }


}
