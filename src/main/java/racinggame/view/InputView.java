package racinggame.view;

import java.util.Scanner;

public class InputView {
    public static int readCount(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextInt();
    }

    public static String readNames(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextLine();
    }
}
