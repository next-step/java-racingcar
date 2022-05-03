package racing;

import java.util.Scanner;

class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    static String scan(String inputText) {
        System.out.println(inputText);
        return scanner.nextLine();
    }

    static int scanNumber(String inputText) {
        System.out.println(inputText);
        return scanner.nextInt();
    }
}