package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expression {

    public static final String OPERATORS = "+-*/";
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";

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
        return userInput.equals("q");
    }

    private static String[] splitUserInputByWhitespace(String userInput) {
        return userInput.split("\\s+");
    }

    public static long evaluate(String[] userInput) {
        long acc = Long.parseLong(userInput[0]);

        for (int i = 1; i < userInput.length - 1; i += 2) {
            String op = userInput[i];
            long term = Long.parseLong(userInput[i + 1]);

            acc = interpreter(acc, term, op);
        }
        return acc;
    }

    private static long interpreter(long acc, long term, String op) {
        switch (op) {
            case ADD:
                return Calculator.add(acc, term);
            case SUB:
                return Calculator.sub(acc, term);
            case MUL:
                return Calculator.mul(acc, term);
            case DIV:
                return Calculator.div(acc, term);
        }
        return 0;
    }
}
