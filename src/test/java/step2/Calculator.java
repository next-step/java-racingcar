package step2;

public class Calculator {
    static long calculate(String input){
        String[] expression = Validator.validateExpression(input);
        long result = Long.parseLong(expression[0]);
        for(int i = 1; i < expression.length; i = i + 2){
            result = Operator.getOperator(expression[i])
                        .calculate(result, expression[i+1]);
        }
        return result;
    }
}
