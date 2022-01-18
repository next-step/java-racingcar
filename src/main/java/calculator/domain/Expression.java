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

    public static void evaluate(String[] userInput) {
        long acc = Integer.parseInt(userInput[0]);

        for(int i = 1; i< userInput.length-1 ; i+=2){
            String op = userInput[i];
            int term = Integer.parseInt(userInput[i + 1]);

            acc = interpreter(acc, term, op);
        }
    }

    private static long interpreter(long acc, int term, String op) {

        return 0;
    }
}
