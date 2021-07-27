package racingCar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_QUESTION_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public String EnterCarName() {
        System.out.println(CAR_NAME_QUESTION_MESSAGE);
        return EnterTxt();
    }

    public int EnterMoveCount() {
        System.out.println(MOVE_COUNT_QUESTION_MESSAGE);
        return EnterNumber();
    }

    private String EnterTxt() {
        return scanner.next();
    }

    private int EnterNumber() {
        return scanner.nextInt();
    }

}
