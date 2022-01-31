package calculator.view;

import calculator.util.Console;
import calculator.util.IsValidInput;
import java.util.ArrayList;
import java.util.List;

public class FormulaInput {

    private FormulaInput() {

    }

    public static List<String> readFormula() {
        List<String> formular = new ArrayList<>();
        try {
            IsValidInput isValidInput = new IsValidInput(Console.readLine());
            formular = isValidInput.getFormular();
        } catch (IllegalArgumentException e) {
            FormulaOutput.printExceptionMessage(e.getMessage());
        }
        return formular;
    }

}
