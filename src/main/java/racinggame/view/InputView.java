package racinggame.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String askNumberOfCar() {
        System.out.println("자동차 대수는 몇대인가요?");
        return SCANNER.nextLine();
    }

    public static String askNumberOfAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return SCANNER.nextLine();
    }
}
