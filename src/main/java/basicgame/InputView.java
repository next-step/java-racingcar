package basicgame;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static void printCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printTryInput() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int intInput() {
        return scanner.nextInt();
    }

    public static String stringInput() {
        return scanner.next();
    }
}
