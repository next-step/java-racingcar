package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_COUNT_OF_UNIT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_COUNT_OF_TURN = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public int InputCountOfUnit() {
        System.out.println(MESSAGE_COUNT_OF_UNIT);
        return this.scanner.nextInt();
    }

    public int InputCountOfTurn() {
        System.out.println(MESSAGE_COUNT_OF_TURN);
        return scanner.nextInt();
    }
}
