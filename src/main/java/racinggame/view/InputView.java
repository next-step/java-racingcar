package racinggame.view;

import java.util.Scanner;

public class InputView {

    private final static String CAR_NAME_REQUEST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String NUMBER_OF_ATTEMPTS_QUESTION = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String carNames() {
        System.out.println(CAR_NAME_REQUEST_QUESTION);
        return scanner.nextLine();
    }

    public String numberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_QUESTION);
        return scanner.nextLine();
    }
}
