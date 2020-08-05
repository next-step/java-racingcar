package step3.view;

import step3.lib.PrintMessage;

import java.util.Scanner;

/***
 *  사용자의 입력을 받아 입력한 값을 반환해주는 작업을 처리하는 클래스
 */
public class InputScanner {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputScanner() {}

    public static int getInputNumberOfTry() {
        PrintMessage.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    public static String getInputNamesOfCars() {
        PrintMessage.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.next();
    }
}
