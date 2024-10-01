package carracing;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static int carCountFromUser() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getIntegerInputFromUser();
    }

    public static int moveTryCountFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getIntegerInputFromUser();
    }

    private static int getIntegerInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
