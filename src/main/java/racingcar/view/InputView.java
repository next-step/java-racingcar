package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInteger(String printMessage) {
        System.out.println(printMessage);

        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputString(String printMessage) {
        System.out.println(printMessage);

        return scanner.nextLine();
    }
}
