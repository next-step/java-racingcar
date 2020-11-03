package step3.view.input;

import step3.application.SimulationCondition;
import step3.view.output.Printer;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MUCH_ATTEMPT_QUESTION = "시도할 회수는 몇 회 인가요?";

    public SimulationCondition receiveSimulationCondition() {
        final int numberOfCar = questionAndAnswer(HOW_MANY_CAR_QUESTION);
        final int numberOfAttempts = questionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        return new SimulationCondition(numberOfCar, numberOfAttempts);
    }

    private int questionAndAnswer(final String question) {
        printQuestion(question);
        return receiveAnswer();
    }

    private void printQuestion(final String question) {
        Printer.println(question);
    }

    private int receiveAnswer() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
