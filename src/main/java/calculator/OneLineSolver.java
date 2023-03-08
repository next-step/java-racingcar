package calculator;

import calculator.decision.DecisionType;

public class OneLineSolver {
    public double solve(double num1, double num2, DecisionType decisionType){
        if(decisionType.equals(DecisionType.NONE)){
            return num2;
        }
        if(decisionType.equals(DecisionType.PLUS)){
            return sum(num1, num2);
        }
        if(decisionType.equals(DecisionType.MINUS)){
            return minus(num1, num2);
        }
        if(decisionType.equals(DecisionType.MULTIPLY)){
            return multiply(num1, num2);
        }

        if(decisionType.equals(DecisionType.DIVIDE)){
            return divide(num1, num2);
        }
        return 0;
    }

    private double sum(double num1, double num2){
        return num1 + num2;
    }
    private double minus(double num1, double num2){
        return num1 - num2;
    }

    private double multiply(double num1, double num2){
        return num1 * num2;
    }

    private double divide(double num1, double num2){
        return num1 / num2;
    }
}
