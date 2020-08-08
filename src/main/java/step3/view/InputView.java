package step3.view;

import java.util.Scanner;

import static step3.constant.MagicNumber.*;

public class InputView {
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
