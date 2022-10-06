package racingcar;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int readInt(String displayText) {
        System.out.println(displayText);
        return scanner.nextInt();
    }

    public static List<String> readStringList(String displayText, String delimiter) {
        System.out.println(displayText);
        return List.of(scanner.nextLine().split(delimiter));
    }

}
