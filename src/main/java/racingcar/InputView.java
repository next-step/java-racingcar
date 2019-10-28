package racingcar;

import java.util.Scanner;

public class InputView {

    private UserInput input;
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    void createInput() {
        this.input = new UserInput(enterCarNumber(), enterRunNumber());
    }

    private int enterCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int enterRunNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public UserInput getInput() {
        return input;
    }
}
