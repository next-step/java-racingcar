package view;

import domain.UserInput;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String FIRST_QUESTION_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private static final String SECOND_QUESTION_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";

    public static UserInput getInput() {
        return getUserInputForRace();
    }

    private static UserInput getUserInputForRace() {
        System.out.println(FIRST_QUESTION_CAR_NUMBER);
        int carNumber = scanner.nextInt();
        System.out.println(SECOND_QUESTION_ATTEMPT_COUNT);
        int attemptCount = scanner.nextInt();

        return new UserInput(carNumber, attemptCount);
    }

}
