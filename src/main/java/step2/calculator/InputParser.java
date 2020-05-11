package step2.calculator;

import static step2.calculator.Validator.*;

public class InputParser {

    private InputParser() {

    }

    static String[] parseInput(String input) {
        checkNullOrEmpty(input);
        String[] parsedInput = input.split(" ");
        checkValidLength(parsedInput);

        return parsedInput;
    }
}
