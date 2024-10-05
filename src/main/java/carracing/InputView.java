package carracing;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String[] carNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getStringInputFromUser().split(",");
    }

    public static int moveTryCountFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getIntegerInputFromUser();
    }

    private static int getIntegerInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static String getStringInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
