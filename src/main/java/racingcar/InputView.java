package racingcar;

import java.util.Scanner;

/**
 * 자동차 경주 입력 클래스
 */
public class InputView {

    private int carCount;   // 경주용 자동차 수
    private int moveCount;  // 이동 횟수, 시도 횟수

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    /**
     * 입력질문 출력
     * @param questions 입력질문
     */
    public void printQuestions(String questions) {
        System.out.println(questions);
    }

    /**
     * 자동차 수 입력받기
     * @param scanner 입력 스캐너
     */
    public void inputCarCount(Scanner scanner) {
        this.carCount = scanner.nextInt();
    }

    /**
     * 이동횟수 입력받기
     * @param scanner 입력 스캐너
     */
    public void inputMoveCount(Scanner scanner) {
        this.moveCount = scanner.nextInt();
    }

}
