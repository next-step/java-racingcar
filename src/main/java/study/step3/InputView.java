package study.step3;

import java.util.Scanner;

public class InputView {
    /* 자동차 수 입력 */
    public int inputCarCount() {
        return input("자동차 대수는 몇 대 인가요?");
    }

    /**
     * input 입력 받기위한 안내 문구 및 입력 받기
     * @param message
     * @return 입력받은 숫자
     */
    private int input(String message) {
        Scanner scanner = new Scanner(System.in);
        ResultView.printMessage(message);
        return scanner.nextInt();
    }

    /* 시도 회수 입력 */
    public int inputRacingCount() {
        return input("시도할 회수는 몇 회 인가요?");
    }
}
