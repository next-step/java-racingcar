package racingcar.view;

import racingcar.domain.RacingCarNames;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class InputView implements Closeable {

    private static final String CAR_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String LAB_INPUT_PROMPT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final String CAR_NAMES_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    private void printCarInputPromptMessage() {
        System.out.println(CAR_INPUT_PROMPT_MESSAGE);
    }

    private void printLamInputPromptMessage() {
        System.out.println(LAB_INPUT_PROMPT_MESSAGE);
    }

    private int nextInt() {
        return scanner.nextInt();
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public RacingCarNames carNames() {
        printCarInputPromptMessage();

        return new RacingCarNames(nextLine().split(CAR_NAMES_DELIMITER));
    }

    public int labCount() {
        printLamInputPromptMessage();
        return nextInt();
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
