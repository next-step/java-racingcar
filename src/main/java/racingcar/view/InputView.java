package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String enter() {
        return scanner.nextLine();
    }

    public int enterNumber() {
        return scanner.nextInt();
    }

}
