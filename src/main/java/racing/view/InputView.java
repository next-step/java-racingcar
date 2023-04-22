package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_NAMES_OF_UNIT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_COUNT_OF_TURN = "시도할 회수는 몇 회 인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    public InputDto InputCountOfUnit() {
        System.out.println(MESSAGE_NAMES_OF_UNIT);
        String nameInput = scanner.next();
        System.out.println(MESSAGE_COUNT_OF_TURN);
        int count = scanner.nextInt();
        return new InputDto(nameInput, count);
    }
}
