package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final String QUIT = "q";

    private Input() {}

    public static String getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        while (true) {
            System.out.print("식을 입력해 주세요(그만하려면 q): ");
            userInput = br.readLine().trim();
            try {
                Validator.checkIsBlack(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (isQuit(userInput)) {
            System.exit(0);
        }

        return userInput;
    }

    private static boolean isQuit(String userInput) {
        return userInput.equals(QUIT);
    }
}
