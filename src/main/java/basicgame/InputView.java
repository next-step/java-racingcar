package basicgame;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static void printCarInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printTryInput() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int countInput() {
        return scanner.nextInt();
    }
}
