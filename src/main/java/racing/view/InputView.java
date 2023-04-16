package racing.view;

import java.util.Scanner;

public class InputView {

<<<<<<< HEAD
    private static final String MESSAGE_NAMES_OF_UNIT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_COUNT_OF_TURN = "시도할 회수는 몇 회 인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    public InputDto InputCountOfUnit() {
        System.out.println(MESSAGE_NAMES_OF_UNIT);
        String nameInput = scanner.next();
        System.out.println(MESSAGE_COUNT_OF_TURN);
        int count = scanner.nextInt();
        return new InputDto(nameInput, count);
=======
    private static final String MESSAGE_COUNT_OF_UNIT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_COUNT_OF_TURN = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int InputCountOfUnit() {
        System.out.println(MESSAGE_COUNT_OF_UNIT);
        return this.scanner.nextInt();
    }

    public int InputCountOfTurn() {
        System.out.println(MESSAGE_COUNT_OF_TURN);
        return scanner.nextInt();
>>>>>>> 583de095d (main 메서드에서 호출할 입력용, 출력용 view 단 클래스 정의)
    }
}
