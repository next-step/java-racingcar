package step3;

import java.util.Scanner;

/***
 *  사용자의 입력을 받아 입력한 값을 반환해주는 작업을 처리하는 클래스
 */
public class InputScanner {

    private final static InputScanner INPUT_SCANNER = new InputScanner();

    private final static Scanner scanner = new Scanner(System.in);

    public static InputScanner getInstance() {
        return INPUT_SCANNER;
    }

    public static void printMessage(String message) {
        System.out.printf(message);
    }

    public static int getInt() {
        return scanner.nextInt();
    }

    public static int getInputNumberOfCar() {
        printMessage("자동차 대수는 몇 대 인가요?");
        return getInt();
    }

    public static int getInputNumberOfTry() {
        printMessage("시도할 회수는 몇 회 인가요?");
        return getInt();
    }
}
