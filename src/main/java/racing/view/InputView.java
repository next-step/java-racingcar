package racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputInt(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }

    public String input(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

}
