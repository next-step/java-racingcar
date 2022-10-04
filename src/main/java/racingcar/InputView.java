package racingcar;

import java.util.Scanner;

public class InputView {

    private InputView() {
        throw new AssertionError();
    }

    private final static Scanner scanner = new Scanner(System.in);

    public static int readInt(String displayText) {
        System.out.println(displayText);
        return scanner.nextInt();
    }

}
