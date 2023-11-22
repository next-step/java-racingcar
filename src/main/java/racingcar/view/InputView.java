package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int userInput(String msg) {
        ResultView.output(msg);
        return scanner.nextInt();
    }

    public static String nameInput(String msg) {
        ResultView.output(msg);
        return scanner.nextLine();
    }
}
