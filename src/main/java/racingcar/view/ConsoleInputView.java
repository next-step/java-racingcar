package racingcar.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static String QUESTION_IDENTIFIER_OF_CARS = "Enter the list of cars (Names are separated with ','): ";
    private static String QUESTION_NUMBER_OF_TRY = "How many trials?";

    private final Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    public String getIdentifierOfCars() {
        showQuestionOfTheNumberOfCars();
        return readIdentifierOfCarsFromInput();
    }

    private void showQuestionOfTheNumberOfCars() {
        System.out.println(QUESTION_IDENTIFIER_OF_CARS);
    }

    private String readIdentifierOfCarsFromInput() {
        try {
            return scanner.nextLine();
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
