package step3.view.input;

import step3.application.SimulationCondition;
import step3.view.ViewString;
import step3.view.output.Printer;

import java.util.Scanner;

import static step3.view.ViewString.HOW_MANY_CAR_QUESTION;
import static step3.view.ViewString.HOW_MUCH_ATTEMPT_QUESTION;

public class InputView {
    private InputView() {
        throw new AssertionError();
    }

    public static SimulationCondition receiveSimulationCondition() {
        final int numberOfCar = questionAndAnswer(HOW_MANY_CAR_QUESTION);
        final int numberOfAttempts = questionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        return new SimulationCondition(numberOfCar, numberOfAttempts);
    }

    private static int questionAndAnswer(final ViewString question) {
        printQuestion(question);
        return receiveAnswer();
    }

    private static void printQuestion(final ViewString question) {
        Printer.println(question);
    }

    private static int receiveAnswer() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
