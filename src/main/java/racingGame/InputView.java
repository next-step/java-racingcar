package racingGame;

import java.util.Scanner;

public class InputView {

    public static int inputGameValue(InputType inputType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputType.getMessage());
        return scanner.nextInt();
    }
}
