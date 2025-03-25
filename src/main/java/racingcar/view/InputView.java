package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        return scanner.nextLine();
    }

    public int getNumberOfRounds() {
        return scanner.nextInt();
    }
}
