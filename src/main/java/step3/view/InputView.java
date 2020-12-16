package step3.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int input(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
