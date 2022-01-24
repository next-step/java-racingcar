package stringcalculator.domain;

import stringcalculator.common.UserInput;

import java.io.*;

public class CalculatorInit {

    private static final String repeatPhrase = "계속하려면 1번을 눌러주세요.";
    private static final int NUMBER_ONE = 1;
    private static int judgeContinue = 0;

    public void start() {
        do {
            continueCalculator();
        } while (repeatCalculator());
    }

    private void continueCalculator() {

        UserInput input = new UserInput();
        while (input.userInputRun())
            ;
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            Calculator calculator = Calculator.of(input.getSplitUserInput());
            log.write(String.valueOf(calculator.getResult()) + '\n');
            log.flush();
        } catch (IllegalArgumentException | IOException exception) {
            exception.getMessage();
        }
    }

    private boolean repeatCalculator() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            log.write(repeatPhrase + '\n');
            log.flush();
            judgeContinue = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException exception) {
            exception.getMessage();
        }

        return judgeContinue == NUMBER_ONE;
    }

}
