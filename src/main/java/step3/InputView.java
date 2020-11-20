/*
 * 자동차 대수와 시도할 횟수를 입력 받는 UI 클래스
 * */
package step3;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    
    public void init() {
        scanner = new Scanner(System.in);
    }

    public void showInputCarMessage() {
        System.out.println(Constants.MSG_NUMBER_OF_CARS);
    }

    public int inputCarNumber() {
        return scanner.nextInt();
    }

    public void showInputRoundMessage() {
        System.out.println(Constants.MSG_ROUNDS);
    }

    public int inputRound() {
        return scanner.nextInt();
    }
}
