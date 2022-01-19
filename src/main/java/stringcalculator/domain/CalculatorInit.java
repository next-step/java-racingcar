package stringcalculator.domain;

import stringcalculator.common.UserInput;

import java.io.*;

public class CalculatorInit {

    private static final String repeatPhrase = "계속하려면 1번을 눌러주세요.";

    private void continueCalculator() {


        UserInput input = new UserInput();


        Calculator calculator = Calculator.of(input.getSplitUserInput());
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            log.write(String.valueOf(calculator.getResult()) + '\n');
            log.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void start() {


    }
}
