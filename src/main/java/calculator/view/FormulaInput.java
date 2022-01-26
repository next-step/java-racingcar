package calculator.view;

import calculator.domain.Formular;
import calculator.util.IsValidInput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FormulaInput {

    public static List<String> getFormula() {
        List<String> formular = new ArrayList<>();
        System.out.println(FormulaOutput.REQUIRE_FORMULA_INPUT_MESSAGE);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            IsValidInput.isBlankOrNot(input);
            formular = Formular.stringSpliter(input);
            IsValidInput.isNotNumber(formular);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(FormulaOutput.ERROR_MESSAGE + e.getMessage());
        }
        return formular;
    }

}
