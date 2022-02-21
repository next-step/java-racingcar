package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarName() {
        String userInput = scanner.nextLine();

        return userInput.split(",");
    }

    public static int getTryCount() {
        return scanner.nextInt();
    }
}
