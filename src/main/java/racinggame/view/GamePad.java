package racinggame.view;

import java.util.Scanner;

public class GamePad {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void printNumOfCarInputMsg() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printNumOfGameInputMsg() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int insertData() {
        return scanner.nextInt();
    }

}
