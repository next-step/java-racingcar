package step2;

import java.util.regex.Pattern;

public class Calculator {

    private int result;
    private Operator currentOperator;
    private static final String regExp = "^[0-9]*$";

    public int calculateFormula(String[] formulaArray){

        result = 0;
        currentOperator = Operator.PLUS;

        for(String input : formulaArray){
            calculatePartial(input);
        }

        return result;
    }

    private void calculatePartial(String input){

        if(Pattern.matches(regExp, input)){
            result = currentOperator.operate(result, Integer.parseInt(input));
            return;
        }

        currentOperator = Operator.findOperator(input);

    }

}