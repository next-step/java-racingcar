package study;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int enterNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return enterNumber();
    }

    public static int enterNumberOfAttempt() {
        System.out.println("시도할 대수는 몇 회 인가요?");
        return enterNumber();
    }

    private static int enterNumber() {
        return SCANNER.nextInt();
    }
}
