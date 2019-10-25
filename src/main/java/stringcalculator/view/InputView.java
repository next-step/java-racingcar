package stringcalculator.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String input() {
        return scanner.nextLine();
    }
}
