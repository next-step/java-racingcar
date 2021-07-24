package racingCar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_QUESTION_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner = new Scanner(System.in);

    public String EnterCarName() {
        System.out.println(CAR_NAME_QUESTION_MESSAGE);
        return EnterTxt();
    }

    public int EnterMoveCount() {
        System.out.println(MOVE_COUNT_QUESTION_MESSAGE);
        return EnterNumber();
    }

    public String EnterTxt() {
        return scanner.next();
    }

    public int EnterNumber() {
        return scanner.nextInt();
    }

}
