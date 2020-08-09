package step3.view;

import java.util.Scanner;

public class InputView {
    public static final String FIRST_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String WRONG_ARGUMENT = "잘못된 인자입니다.";
    public static final String QUESTION_NUMBER_ONE = "1";
    public static final String QUESTION_NUMBER_TWO = "2";
    private Scanner scanner = new Scanner(System.in);
    private int trialCounts;
    private int numberOfCars;

    public InputView() {
        this.trialCounts = 0;
        this.numberOfCars = 0;
    }

    public static String askQuestion(String value) {
        if (value.equals(QUESTION_NUMBER_ONE)) {
            return FIRST_QUESTION;
        }
        if (value.equals(QUESTION_NUMBER_TWO)) {
            return SECOND_QUESTION;
        }
        return WRONG_ARGUMENT;
    }

    public void runInputView() {
        System.out.println(InputView.askQuestion(QUESTION_NUMBER_ONE));
        numberOfCars = scanner.nextInt();
        System.out.println(InputView.askQuestion(QUESTION_NUMBER_TWO));
        trialCounts = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTrialCounts() {
        return trialCounts;
    }
}
