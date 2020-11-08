package step5.client.view.input;

import step5.worker.application.SimulationRequest;
import step5.client.view.output.Printer;

import java.util.Scanner;

public class RacingGameInputView {
    private RacingGameInputView() {
        throw new AssertionError();
    }
    private static final String ENTER_THE_NAME_OF_THE_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MUCH_ATTEMPT_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static SimulationRequest receiveInputs() {
        final String carNames = questionAndAnswer(ENTER_THE_NAME_OF_THE_CARS);
        final String numberAttempts = questionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        return SimulationRequest.of(carNames, numberAttempts);
    }

    private static String questionAndAnswer(final String question) {
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
