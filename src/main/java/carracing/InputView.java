package carracing;

import java.util.Scanner;

public class InputView {

    public int getInputValue(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }
}
