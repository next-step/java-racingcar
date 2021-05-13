package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private String userInput;
    private int result = 0;
    private Operator currentOperator = Operator.PLUS;

    public int caculateUserInput() {
        for (String partialInput : userInput.split(" ")) {
            calculatePartial(partialInput);
        }

        return result;
    }

    public void setUserInput(String userInput){
        this.userInput = userInput;
    }

    private void calculatePartial(String input){

        String regExp = "^[0-9]*$";

        if(Pattern.matches(regExp, input)){
            result = currentOperator.operate(result, Integer.parseInt(input));
            return;
        }

        for(Operator operator : Operator.values()){
            if(operator.getSymbol().equals(input)){
                currentOperator = operator;
                return;
            }
        }

        throw new IllegalArgumentException();

    }

}
