package StringCalculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

    private final String STRING_SPLIT_DELIMETER = " ";

    //주어진 문자열을 계산한다.
    public double calculate(ArithmeticExpression arithmeticExpression){

        double preNumber = 0;
        double nextNumber = 0;
        double sum = 0;

        arithmeticExpressionValidation(arithmeticExpression);

//        Validator operationValidator = new OperationValidator();

        String [] expressionArr = this.splitString(arithmeticExpression.toString());
        preNumber = Double.parseDouble(expressionArr[0]);

        for(int i=0 ; i < expressionArr.length ; i++) {
            Optional<Operation> operation = getProperOperation(expressionArr[i]);
            //연산 문자의 경우
            if(operation.isPresent()) {
                //연산
                nextNumber = Double.parseDouble(expressionArr[i+1]);
                sum = operation.get().operate(preNumber, nextNumber);
                preNumber = sum;
                continue;
            }
        }
        return sum;
    }

    public String [] splitString(String arithmeticExpression) {
        return arithmeticExpression.split(STRING_SPLIT_DELIMETER);
    }

    public void arithmeticExpressionValidation(ArithmeticExpression arithmeticExpression) {
        String expression = arithmeticExpression.toString();
        Validator nullValidator = new NullValidator();
        Validator arithmeticValidator = new ArithmeticValidator();

        //Null Validation Check
        nullValidator.validate(expression);

        //Arithmetic Validation Check
        arithmeticValidator.validate(expression);
    }

    private Optional<Operation> getProperOperation(String operationString) {
        return Arrays.stream(Operation.values())
                .filter(operation -> {return operation.toString().equals(operationString);})
                .findFirst();
    }

}
