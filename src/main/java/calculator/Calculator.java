package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    private String formula;
    private List<String> parsedElements;

    public Calculator() {
        setFormula();
        parseFormula();
        validateFormulaIsNull();
        validateFormulaOperator();
        validateFormulaHasOneBlank();
    }

    public Calculator(String formula) {
        this.formula = formula;
        validateFormulaOperator();
    }

    private void setFormula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요: ");
        formula = scanner.nextLine();
    }

    private void parseFormula() {
        parsedElements = Arrays.asList(formula.split(" "));
    }

    public void validateFormulaIsNull() {
        // 입력 null X
        if (formula == null) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    public void validateFormulaOperator() {
        // 사칙연산 기호 이외의 것 X
        boolean matches = Pattern.matches("^[0-9+\\-*/ ]*$", formula);
        if (!matches) {
            throw new IllegalArgumentException("숫자 및 사칙연산자, 공백 기호 이외에는 입력할 수 없습니다.");
        }
    }

    public void validateFormulaHasOneBlank() {
        // 공백 2자 이상 X
        if (formula.contains("  ")) {
            throw new IllegalArgumentException("공백이 두 자 이상일 수 없습니다.");
        }
    }

}
