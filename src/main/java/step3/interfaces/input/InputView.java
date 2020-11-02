package step3.interfaces.input;

import step3.application.SimulationCondition;
import step3.interfaces.output.Printer;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MUCH_ATTEMPT_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static SimulationCondition receiveSimulationCondition() {
        final int numberOfCar = QuestionAndAnswer(HOW_MANY_CAR_QUESTION);
        final int numberOfAttempts = QuestionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        return new SimulationCondition(numberOfCar, numberOfAttempts);
    }

    private static int QuestionAndAnswer(final String question) {
        printQuestion(question);
        return receiveAnswer();
    }

    private static void printQuestion(final String question) {
        Printer.println(question);
    }

    private static int receiveAnswer() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
