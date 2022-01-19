package calculator.service;

import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static int run(List<String> formula){
        Stack<String> formulaStack = new Stack<>();

        for(int i = formula.size()-1; i>=0; i--){
            formulaStack.push(formula.get(i));
        }
        while(formulaStack.size() > 1){
            int prev = Integer.parseInt(formulaStack.pop());
            Operation operator = Operation.fromString(formulaStack.pop()).get();
            int next = Integer.parseInt(formulaStack.pop());

            int result = 0;
            if(Operation.PLUS == operator){
                result = add(prev, next);
            }else if(Operation.MINUS == operator){
                result = sub(prev, next);
            }else if(Operation.TIMES == operator){
                result = multiply(prev, next);
            }else if(Operation.DIVDE == operator){
                result = divide(prev, next);
            }
            formulaStack.push(String.valueOf(result));
        }

        return Integer.parseInt(formulaStack.pop());
    }

    public static int add(int prev, int next) {
        return prev + next;
    }

    public static int sub(int prev, int next) {
        return prev - next;
    }

    public static int multiply(int prev, int next) {
        return prev * next;
    }

    // TODO: 실수형 고려
    public static int divide(int prev, int next) {
        return prev / next;
    }
}
