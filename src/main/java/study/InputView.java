package study;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        return scanner.nextLine();
    }

    public static int getNumberOfTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
