package step2;

import step2.FourOperation.*;

public class FourOperationFactory implements OperationFactory{
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";

    @Override
    public Operation getOperation(String operation) {

        if(operation.equals(PLUS)) {
            return new PlusOperation();
        }

        if(operation.equals(MINUS)) {
            return new MinusOperation();
        }

        if(operation.equals(MULTIPLY)) {
            return new MultiplyOperation();
        }

        if(operation.equals(DIVIDE)) {
            return new DivideOperation();
        }

        return Operation.NONE;
    }
}
