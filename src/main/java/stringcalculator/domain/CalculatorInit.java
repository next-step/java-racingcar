package stringcalculator.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import stringcalculator.common.UserInput;

public class CalculatorInit {

    private static final String repeatPhrase = "계속하려면 1번을 눌러주세요.";
    private static final int NUMBER_ONE = 1;
    private static final String NEW_LINE = "\n";
    private static final CalculatorInit calculatorInit;
    private static int judgeContinue = 0;

    static {
        calculatorInit = new CalculatorInit();
    }

    private CalculatorInit() {
    }

    public static CalculatorInit getInstance() {
        return calculatorInit;
    }

    public void start() throws IOException {
        do {
            continueCalculator();
        } while (repeatCalculator());
    }

    private void continueCalculator() throws IOException {

        UserInput input = new UserInput();

        while (input.userInputValidCheck()) {
            input.userInputRun();
        }

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            Calculator calculator = Calculator.of(input.getSplitUserInput());
            log.write(String.valueOf(calculator.process()) + NEW_LINE);
            log.flush();
        } catch (IllegalArgumentException | IOException exception) {
            log.write(exception.getMessage());
            log.flush();
        }
    }

    private boolean repeatCalculator() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            log.write(repeatPhrase + NEW_LINE);
            log.flush();
            judgeContinue = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException exception) {
            exception.getMessage();
        }

        return judgeContinue == NUMBER_ONE;
    }

}

