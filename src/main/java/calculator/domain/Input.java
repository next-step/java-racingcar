package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final String QUIT = "q";

    private Input() {}

    public static String getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userInput = br.readLine().trim();
        Validator.checkIsBlack(userInput);

        if (isQuit(userInput)) {
            System.exit(0);
        }

        return userInput;
    }

    private static boolean isQuit(String userInput) {
        return userInput.equals(QUIT);
    }
}
