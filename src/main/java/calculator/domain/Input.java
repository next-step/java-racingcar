package calculator.domain;

import java.util.Scanner;

public class Input {

    private static final String QUIT = "q";

    private Input() {}

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        String userInput;

        while (true) {
            System.out.print(String.format("식을 입력해 주세요(그만하려면 %s): ", QUIT));
            userInput = scanner.nextLine().trim();
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
