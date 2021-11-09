package step3.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Integer getRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String getCarNames() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextLine();
    }
}
