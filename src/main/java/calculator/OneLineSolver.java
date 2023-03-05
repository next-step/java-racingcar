package calculator;

import calculator.decision.DecisionType;

public class OneLineSolver {
    public double solve(double num1, double num2, DecisionType decisionType){
        switch(decisionType){
            case NONE:
                return num2;
            case PLUS:
                return sum(num1, num2);
            case MINUS:
                return minus(num1, num2);
            case MULTIPLY:
                return multiply(num1, num2);
            case DIVIDE:
                return divide(num1, num2);
        }
        return 0;
    }

    public double sum(double num1, double num2){
        return num1 + num2;
    }
    public double minus(double num1, double num2){
        return num1 - num2;
    }

    public double multiply(double num1, double num2){
        return num1 * num2;
    }

    public double divide(double num1, double num2){
        return num1 / num2;
    }
}
