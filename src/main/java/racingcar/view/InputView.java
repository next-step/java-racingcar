package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputInteger(String printMessage) {
        System.out.println(printMessage);

        return Integer.parseInt(scanner.nextLine());
    }
}
