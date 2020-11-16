/*
 * 클래스 이름
 * 입력 메세지 뷰
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView () {
        scanner = new Scanner(System.in);
    }

    public int inputTryCountMessage () {
        printInputTryCountMessage();
        return inputTryCount();
    }

    public String inputCarNamesMessage () {
        printInputCarNamesMessage();
        return inputCarNames();
    }

    private void printInputTryCountMessage () {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    private int inputTryCount () {
        return isDigit(scanner.nextLine());
    }

    private void printInputCarNamesMessage () {
        System.out.println("자동차 이름들을 입력해주세요. (,로 구분)");
    }

    private String inputCarNames () {
        return scanner.nextLine();
    }

    public int isDigit (String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(number);
    }
}
