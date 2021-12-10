package racingcar.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class RacingCarScanner implements Closeable {

    private static final String CAR_INPUT_PROMPT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String LAB_INPUT_PROMPT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public RacingCarScanner() {
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

    public int carCount() {
        printCarInputPromptMessage();
        return nextInt();
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
