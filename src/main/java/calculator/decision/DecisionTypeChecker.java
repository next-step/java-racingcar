package calculator.decision;

import calculator.input.CalculatorInputType;

public class DecisionTypeChecker {
    public static DecisionType check(char ch){
        switch (ch){
            case '+':
                return DecisionType.PLUS;
            case '-':
                return DecisionType.MINUS;
            case '*':
                return DecisionType.MULTIPLY;
            case '/':
                return DecisionType.DIVIDE;
        }
        return DecisionType.ERROR;
    }

}
