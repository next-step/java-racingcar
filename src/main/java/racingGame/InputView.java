package racingGame;

import java.util.Scanner;

public class InputView {

    public static int inputMove(InputType inputType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputType.getMessage());
        return scanner.nextInt();
    }

    public static String inputCarNames(InputType inputType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputType.getMessage());
        return scanner.nextLine();
    }
}
