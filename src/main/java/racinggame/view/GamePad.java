package racinggame.view;

import java.util.Scanner;
import racinggame.domain.exception.IntegerMismatchException;

public class GamePad {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void printCarNamesInputMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printNumOfRoundInputMsg() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int insertIntData() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IntegerMismatchException();
        }
    }

    public static String insertStringData() {
        return scanner.next();
    }

}
