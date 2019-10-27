/*
 * InputView.java  1.0.0   2019.10.27
 */
package step2;

import java.util.Scanner;

/**
 * 자동차 게임 사용자 입력 부분
 * @version 1.0.0
 * @author naheenosaur
 */
public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TURN_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    int carNum;
    int turn;

    public int getCarNum() {
        return carNum;
    }

    public int getTurn() {
        return turn;
    }

    public void input() {
        carNum = getAnswerForQuestion(CAR_COUNT_QUESTION);
        turn = getAnswerForQuestion(TURN_COUNT_QUESTION);
    }

    private int getAnswerForQuestion(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
