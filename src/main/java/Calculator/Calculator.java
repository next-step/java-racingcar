package Calculator;

import java.util.zip.DataFormatException;

public class Calculator {

    private final String[] formula;

    public Calculator(String formula) {
        this.formula = getSplitInputByValidationParam(formula);
    }

    public Integer execute() throws DataFormatException {
        Integer result = Integer.parseInt(formula[0]);

        for (int i = 1; i < formula.length; i = i + 2) {
            result = calculate(result, i);
        }

        return result;
    }

    private Integer calculate(Integer first, Integer operatorIdx) throws DataFormatException {
        try {
            return Operator.getValue(formula[operatorIdx]).calculate(first, Integer.parseInt(formula[operatorIdx + 1]));
        } catch (DataFormatException e) {
            throw new DataFormatException(e.getMessage() + " : " + formula[operatorIdx]);
        }
    }

    private String[] getSplitInputByValidationParam(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 존재하지 않습니다.");
        }

        String[] result = input.split(CalculatorUtils.BLANK);
        if (!this.isOdd(result.length)) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다.");
        }

        return result;
    }

    private Boolean isOdd(Integer number) {
        return number % 2 == 1;
    }

}
