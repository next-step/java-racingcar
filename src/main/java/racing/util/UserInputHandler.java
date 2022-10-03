package racing.util;

import java.util.Scanner;

public abstract class UserInputHandler {
    static Scanner scanner = new Scanner(System.in);

    public String scan() {
        return scanner.nextLine();
    }

    public abstract boolean validate(Object userInput);
}
