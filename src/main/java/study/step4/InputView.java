package study.step4;

import java.util.Scanner;

public class InputView {
    static private Scanner scanner = new Scanner(System.in);
    /* 자동차 이름 입력 */
    static public String inputCars() {
        return inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    /**
     * inputString 입력 받기위한 안내 문구 및 입력 받기
     * @param message
     * @return 입력받은 문자열
     */
    static private String inputString(String message) {
        ResultView.printlnMessage(message);
        return scanner.next();
    }

    /* 시도 회수 입력 */
    static public int inputRacingCount() {
        return inputInt("시도할 회수는 몇회인가요?");
    }

    /**
     * inputInt 입력 받기위한 안내 문구 및 입력 받기
     * @param message
     * @return 입력받은 숫자
     */
    static private int inputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        ResultView.printlnMessage(message);
        return scanner.nextInt();
    }
}
