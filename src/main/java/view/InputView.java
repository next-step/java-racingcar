package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String inputCarsName() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputAttemptCount() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
        return scanner.nextLine();
    }
}
