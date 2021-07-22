package racingCar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NUMBER_QUESTION_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";
    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int EnterCarNumber() {
        System.out.println(CAR_NUMBER_QUESTION_MESSAGE);
        return EnterNumber();
    }

    public int EnterMoveCount() {
        System.out.println(MOVE_COUNT_QUESTION_MESSAGE);
        return EnterNumber();
    }

    public int EnterNumber() {
        return scanner.nextInt();
    }

}
