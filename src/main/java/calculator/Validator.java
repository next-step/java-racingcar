package calculator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public boolean isInputBlankSafe(String input){
        return !(isSplitByBlank(input) || isBlank(input) || isNull(input));
    }
    public boolean isSplitByBlank(String input){ return input.split(" ").length >= 2; }
    public boolean isBlank(String input){
        return input.equals(" ");
    }
    public boolean isNull(String input){ return input.isEmpty(); }

    public boolean isCalculatable(List<String> parsedString){
        boolean calculatableFlag = true;
        boolean numberFlag = true;
        for(String value:parsedString){
            calculatableFlag &= isValidExpression(numberFlag, value);
            numberFlag = !numberFlag;
        }
        return calculatableFlag;
    }

    public boolean isValidExpression(boolean numberFlag, String input){
        if(numberFlag) return isNumber(input);
        return isOperator(input);
    }

    public boolean isOperator(String input){return Pattern.matches("[-+*/]", input);}
    public boolean isNumber(String input){ return Pattern.matches("[0-9]+", input); }

}
