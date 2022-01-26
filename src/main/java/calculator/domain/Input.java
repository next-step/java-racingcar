package calculator.domain;

import static calculator.domain.Constants.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private Input() {}

    public static String[] getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userInput = br.readLine().trim();
        if (isQuit(userInput)) {
            System.exit(0);
        }

        String[] splitUserInput = splitUserInputByWhitespace(userInput);
        Validator.validateUserInput(splitUserInput);

        return splitUserInput;
    }

    private static boolean isQuit(String userInput) {
        return userInput.equals(QUIT_COMMAND);
    }

    private static String[] splitUserInputByWhitespace(String userInput) {
        return userInput.split(SPLIT_DELIMITER);
    }

}
