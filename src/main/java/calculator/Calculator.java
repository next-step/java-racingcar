package calculator;

public class Calculator {

    private String[] formula;

    public Calculator(String input) {
        validationEmptyWithFormula(input);
    }

    private void validationEmptyWithFormula(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("수식이 비워져 있습니다.");
        }
    }


}
