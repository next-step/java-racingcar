package step3.common.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int input() {
        return scanner.nextInt();
    }

}
