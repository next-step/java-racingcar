package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expression {
    public static final String OPERATORS = "+-*/" ;

    public static String[] getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitUserInput = br.readLine().split("\\s+");

        Validator.validateUserInput(splitUserInput);

        return splitUserInput;
    }

    public static void evaluate(String userInput) {
        String[] splitUserInput = userInput.split("\\s+");
    }
}
