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

import model.Race;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    Race race;

    public InputView () {
        this.race = new Race();
        scanner = new Scanner(System.in);
    }

    public Race getRace () {
        return race;
    }

    public void inputMessage () {
        printInputCarCountMessage();
        inputCarCount();
        printInputTryCountMessage();
        inputTryCount();
    }

    private void printInputCarCountMessage () {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void inputCarCount () {
        race.setCars(isDigit(scanner.nextLine()));
    }

    private void printInputTryCountMessage () {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void inputTryCount () {
        race.setTryCount(isDigit(scanner.nextLine()));
    }

    public int isDigit (String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(number);
    }
}
