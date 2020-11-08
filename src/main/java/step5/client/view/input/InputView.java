package step5.client.view.input;

import step5.client.worker.application.SimulationRequest;
import step5.client.view.output.Printer;

import java.util.Scanner;

public class InputView {
    private InputView() {
        throw new AssertionError();
    }

    public static String questionAndAnswer(final String question) {
        printQuestion(question);
        return receiveAnswer();
    }

    private static void printQuestion(final String question) {
        Printer.println(question);
    }

    private static String receiveAnswer() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
