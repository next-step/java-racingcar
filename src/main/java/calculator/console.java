package calculator;

import java.util.Scanner;

public class console {
    private String userInput;

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
