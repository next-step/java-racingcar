package step4.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public String inputString(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
