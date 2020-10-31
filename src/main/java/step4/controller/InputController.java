package step4.controller;

import java.util.Scanner;

public class InputController {


    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputController() {
    }

    public static String putCarCount() {
        System.out.println(CAR_NAMES);
        return getString();
    }

    public static int putTryCount() {
        System.out.println(TRY_COUNT);
        return getNumber();

    }

    private static int getNumber() {
        return scanner.nextInt();
    }
    private static String getString(){
        return scanner.nextLine();
    }

}
