package study.step3;

import java.util.Scanner;

public class InputView {
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
}
