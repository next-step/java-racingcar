package calculator.view;

import calculator.domain.Formular;
import calculator.util.Console;
import java.util.ArrayList;
import java.util.List;

public class FormulaInput {

    private FormulaInput() {

    }

    public static List<String> readFormula() {
        List<String> formular = new ArrayList<>();
        try {
            formular = new Formular(Console.readLine()).getSplitedFormular();
        } catch (IllegalArgumentException e) {
            FormulaOutput.printExceptionMessage(e.getMessage());
        }
        return formular;
    }

}
