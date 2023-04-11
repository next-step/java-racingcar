package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getInput() {
        return scanner.nextInt();
    }

    public void finishInput() {
        scanner.close();
    }
}
