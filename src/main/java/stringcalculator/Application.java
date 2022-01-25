package stringcalculator;

import java.io.IOException;
import stringcalculator.domain.CalculatorInit;

public class Application {

    public static void main(String[] args) throws IOException {
        CalculatorInit.getInstance().start();
    }
}

