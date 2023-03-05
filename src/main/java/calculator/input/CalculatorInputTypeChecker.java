package calculator.input;

public class CalculatorInputTypeChecker {
    public static CalculatorInputType check(char ch){
        if(ch == ' '){
            return CalculatorInputType.EMPTY;
        }
        if(Character.isDigit(ch)){
            return CalculatorInputType.NUMBER;
        }
        if(ch == '+'
                || ch == '-'
                || ch == '/'
                || ch == '*'){
            return CalculatorInputType.CALCULATE;
        }
        return CalculatorInputType.ERROR;
    }

}
