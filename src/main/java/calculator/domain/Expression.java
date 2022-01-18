package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expression {
    public static final String OPERATORS = "+-*/" ;

    public static String getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();

        Validator.validateUserInput(userInput);

        return userInput;
    }

}
