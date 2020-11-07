package step3.view.input;

import step3.application.SimulationCondition;
import step3.view.ViewString;
import step3.view.output.Printer;

import java.util.Scanner;

import static step3.view.ViewString.ENTER_THE_NAME_OF_THE_CARS;
import static step3.view.ViewString.HOW_MUCH_ATTEMPT_QUESTION;

public class InputView {
    private InputView() {
        throw new AssertionError();
    }

    public static SimulationCondition receiveSimulationCondition() {
        final String carNames = questionAndAnswer(ENTER_THE_NAME_OF_THE_CARS);
        final String numberAttempts = questionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        return SimulationCondition.of(carNames, numberAttempts);
    }

    private static String questionAndAnswer(final ViewString question) {
        printQuestion(question);
        return receiveAnswer();
    }

    private static void printQuestion(final ViewString question) {
        Printer.println(question);
    }

    private static String receiveAnswer() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
