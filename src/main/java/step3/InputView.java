/*
 * 자동차 대수와 시도할 횟수를 입력 받는 UI 클래스
 * */
package step3;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    /**
     * scanner 클래스 init
     */
    public void init() {
        scanner = new Scanner(System.in);
    }

    /**
     * 자동차 대수 입력 메시지를 출력하는 메소드
     */
    public void showInputCarMessage() {
        System.out.println(Constants.MSG_NUMBER_OF_CARS);
    }

    /**
     * 자동차 대수를 사용자에게 입력 받는 메소드
     */
    public int inputCarNumber() {
        return scanner.nextInt();
    }

    /**
     * 시도 횟수 입력 메시지를 출력하는 메소드
     */
    public void showInputRoundMessage() {
        System.out.println(Constants.MSG_ROUNDS);
    }

    /**
     * 시도 횟수를 사용자에게 입력 받는 메소드
     */
    public int inputRound() {
        return scanner.nextInt();
    }
}
