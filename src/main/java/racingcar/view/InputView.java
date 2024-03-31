package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static String userInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
