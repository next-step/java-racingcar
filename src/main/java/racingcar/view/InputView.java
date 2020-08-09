package racingcar.view;

import java.util.Scanner;
import static java.lang.System.out;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int getSystemIn (String message) {
        out.println(message);
        return scanner.nextInt();
    }

}
