package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int readIntInput(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public String readStringInput(String msg) {
        System.out.println(msg);
        return scanner.next();
    }
}
