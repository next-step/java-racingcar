package step2;

public class Calculator {

    public static int execute(InputString inputString) {
        Operand leftOperand = Operand.from(inputString.get(0));
        for (int i = 0; i < inputString.getLength() - 2; i += 2) {
            Operator operator = Operator.from(inputString.get(i + 1));
            Operand rightOperand = Operand.from(inputString.get(i + 2));
            leftOperand = operator.operate(leftOperand, rightOperand);
        }
        return leftOperand.getValue();

    }
}
