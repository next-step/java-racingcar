package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static String userInput(String message) {
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
