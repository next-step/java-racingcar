package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String enter() {
        return scanner.nextLine();
    }

    public static int enterNumber() {
        return scanner.nextInt();
    }

}
