package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        String s = scanner.nextLine();

        return Arrays.asList(s.trim().split(","));
    }

    public static int getNumberOfRounds() {
        return scanner.nextInt();
    }
}
