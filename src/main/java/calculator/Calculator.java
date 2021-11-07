package calculator;

public class Calculator {

    public Long execute(String input) {
        CalculatorValidator.validateInputParam(input);
        return calculate(input.split(" "));
    }

    private Long calculate(String[] texts) {
        CalculatorValidator.validateNumeric(texts[0]);
        Long result = Long.parseLong(texts[0]);

        int indexSize = texts.length;
        for (int i = 1; i < indexSize; i += 2) {
            CalculatorValidator.validateOperator(texts[i]);

            result = CalculatorHelper.calculate(
                    texts[i],
                    result,
                    Long.parseLong(texts[i + 1]));
        }
        return result;
    }
}
