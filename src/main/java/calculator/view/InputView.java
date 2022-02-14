package calculator.view;

import calculator.domain.Validator;
import java.util.Scanner;

public class InputView {

    public static String getInput() {
        String userInput;
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
        Validator.checkInput(userInput);
        return userInput;
    }
}
