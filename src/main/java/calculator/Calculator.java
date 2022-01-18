package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private String formula;
    private List<String> parsedElements;

    public Calculator() {
        setFormula();
        validateFormula();
        parseFormula();
    }

    // Test
    public Calculator(String formula) {
        this.formula = formula;
        validateFormula();
    }

    private void validateFormula () {
        Validator validator = Validator.getInstance(formula);

        validator.validateFormulaIsNull();
        validator.validateFormulaOperator();
        validator.validateFormulaHasOneBlank();
    }

    private void setFormula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요: ");
        formula = scanner.nextLine();
    }

    private void parseFormula() {
        parsedElements = Arrays.asList(formula.split(" "));
    }
}
