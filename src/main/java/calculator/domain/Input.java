package calculator.domain;

import java.util.Scanner;

public class Input {

    public static String getInput() {
        String userInput;
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
        new Validator(userInput);
        return userInput;
    }
}
