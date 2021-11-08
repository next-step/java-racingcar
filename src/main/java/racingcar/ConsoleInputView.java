package racingcar;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static String QUESTION_NUMBER_OF_CARS = "How many cars are?";
    private static String QUESTION_NUMBER_OF_TRY = "How many trials?";

    private final Scanner scanner;

    ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        showQuestionOfTheNumberOfCars();
        return readNumberOfCarsFromInput();
    }

    private void showQuestionOfTheNumberOfCars() {
        System.out.println(QUESTION_NUMBER_OF_CARS);
    }

    private int readNumberOfCarsFromInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("Number of Cars must be integer!");
        }
    }

    public int getNumberOfTrials() {
        showQuestionOfTheNumberOfTrials();
        return readNumberOfTrialsFromInput();
    }

    private void showQuestionOfTheNumberOfTrials() {
        System.out.println(QUESTION_NUMBER_OF_TRY);
    }

    private int readNumberOfTrialsFromInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("Number of Trials must be integer!");
        }
    }
}
