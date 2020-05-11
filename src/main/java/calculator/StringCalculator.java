package calculator;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringCalculator {

    Queue<Float> operands = new ArrayDeque<>();
    Queue<Operator> operators = new ArrayDeque<>();

    Float beforeNumber = null;

    public float calculate(String formula) {
        checkNullOrEmpty(formula);

        String[] formulaSplit = formula.split(" ");
        separateOperandFromOperator(formulaSplit);

        for(Operator operator = operators.poll() ; operator != null ; operator = operators.poll()) {
            beforeNumber = calculate(getBeforeNumber(), operator, getAfterNumber());
        }

        return beforeNumber;
    }

    private Float calculate(Float beforeNumber, Operator operator, Float afterNumber) {
        return operator.calculate(beforeNumber, afterNumber);
    }

    private void separateOperandFromOperator(String[] formulaSplit) {
        for(String element : formulaSplit) {
            if(Operator.isOperatorSymbol(element)) {
                operators.add(Operator.getOperator(element));
            }
            else{
                operands.add(Float.valueOf(element));
            }
        }
    }

    private Float getBeforeNumber() {
        if(beforeNumber == null) {
            beforeNumber = operands.poll();
        }
        return beforeNumber;
    }

    private Float getAfterNumber() {
        return operands.poll();
    }

    private void checkNullOrEmpty(String str) throws IllegalArgumentException {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Argument is null or empty.");
        }
    }
}
