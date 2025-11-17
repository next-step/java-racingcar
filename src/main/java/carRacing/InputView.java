package carRacing;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int initCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return nextInt();
    }

    public static int initTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return nextInt();
    }

    public static String initCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return nextLine();
    }

    private static String nextLine() {
        return SCANNER.nextLine();
    }

    private static int nextInt() {
        return SCANNER.nextInt();
    }
}
