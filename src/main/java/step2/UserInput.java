package step2;

import java.util.Scanner;

public class UserInput {
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
