package step2;

public class Calculator {
    public Calculator() {}

    public int calculate(String formula) {
        Validator.validationCheck(formula);
        String[] token = formula.split(" ");
        int leftNumber = Integer.parseInt(token[0]);

        for (int i = 1; i < token.length; i+=2) {
            int rightNumber = Integer.parseInt(token[i+1]);
            leftNumber = Operator.getOperator(token[i]).apply(leftNumber,rightNumber);
        }
        return leftNumber;
    }
}
