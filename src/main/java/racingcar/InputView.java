package racingcar;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getCarNames() {
        return scanner.nextInt();
    }

    public static int getNumberOfRounds() {
        return scanner.nextInt();
    }
}
