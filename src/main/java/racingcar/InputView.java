package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int carCount() {
        inputPrintln("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int roundCount() {
        inputPrintln("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
    public static String racerNames() {
        inputPrintln("경주에 참가하는 레이서 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
    private static void inputPrintln(String message) {
        System.out.println(message);
    }
}
