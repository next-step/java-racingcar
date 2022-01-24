package stringcalculator.domain;

import stringcalculator.common.UserInput;

import java.io.*;

public class CalculatorInit {

    private static final String repeatPhrase = "계속하려면 1번을 눌러주세요.";
    private static final int NUMBER_ONE = 1;
    private static int judgeContinue = 0;

    private void continueCalculator() {
        UserInput input = new UserInput();
        Calculator calculator = Calculator.from(input.getSplitUserInput());
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            log.write(String.valueOf(calculator.getResult()) + '\n');
            log.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
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
            exception.printStackTrace();
        }

        return judgeContinue == NUMBER_ONE;
    }

    public void start() {
        continueCalculator();
        while (repeatCalculator()) continueCalculator();
    }

}
