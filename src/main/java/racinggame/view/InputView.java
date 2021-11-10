package racinggame.view;

import java.util.Scanner;

public class InputView {

    private static final String NUMBER_OF_CARS_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_ATTEMPTS_QUESTION = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String numberOfCars() {
        System.out.println(NUMBER_OF_CARS_QUESTION);
        return scanner.nextLine();
    }

    public String numberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_QUESTION);
        return scanner.nextLine();
    }
}
