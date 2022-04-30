package racing;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int scan(String inputText) {
        System.out.println(inputText);
        return scanner.nextInt();
    }
}