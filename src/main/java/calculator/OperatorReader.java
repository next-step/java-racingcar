package calculator;

public class OperatorReader {
    public Operator readOperator(String operator) {
        if("+".equals(operator)) {
            return new PlusOperator();
        }

        if("-".equals(operator)) {
            return new MinusOperator();
        }

        if("*".equals(operator)) {
            return new MultiplyOperator();
        }

        return new DevideOperator();
    }
}
