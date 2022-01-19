package stringcalculator;

import stringcalculator.common.UserInput;
import stringcalculator.domain.Calculator;
import stringcalculator.domain.CalculatorInit;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        new CalculatorInit().start();
    }
}
