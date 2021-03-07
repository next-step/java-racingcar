package step2;

public class Calculator {
    public Calculator() {
    }

    public int calculate(String formula) {
        Validator.validationCheck(formula);
        String[] token = formula.split(" ");
        int leftNumber = StringParser.toInt(token[0]);

        for (int i = 1; i < token.length; i += 2) {
            int rightNumber = StringParser.toInt(token[i + 1]);

            leftNumber = Operator.of(token[i])
                    .apply(leftNumber, rightNumber);
        }
        return leftNumber;
    }
}
