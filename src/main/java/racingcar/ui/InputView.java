package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int readInt() {
        return SCANNER.nextInt();
    }

}
