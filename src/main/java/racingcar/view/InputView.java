package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        return scanner.nextLine();
    }

    public static int inputDriveCount() {
        return Integer.parseInt(scanner.nextLine());
    }
}
