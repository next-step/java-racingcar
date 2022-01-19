package calculator.service;

import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(List<String> formula){
        Stack<String> formulaStack = new Stack<>();

        for(int i = formula.size()-1; i>=0; i--){
            formulaStack.push(formula.get(i));
        }
        while(formulaStack.size() > 1){
            double prev = Double.parseDouble(formulaStack.pop());
            Operation operator = Operation.fromString(formulaStack.pop()).get();
            double next = Double.parseDouble(formulaStack.pop());

            double result = 0;
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

        return Double.parseDouble(formulaStack.pop());
    }

    public static double add(double prev, double next) {
        return prev + next;
    }

    public static double sub(double prev, double next) {
        return prev - next;
    }

    public static double multiply(double prev, double next) {
        return prev * next;
    }

    public static double divide(double prev, double next) {
        return prev / next;
    }
}
