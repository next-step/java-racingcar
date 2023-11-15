package carracing;

import java.util.Scanner;

public class InputView {

    private static InputView instance;

    public int getInputValue(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
}
