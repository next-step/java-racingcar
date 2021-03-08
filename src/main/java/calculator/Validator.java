package calculator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public boolean isInputValid(String input){
        return !(isSplitByBlank(input) || isBlank(input) || isNull(input));
    }

    public boolean isSplitByBlank(String input){
        return input.split(" ").length >= 2;
    }

    public boolean isBlank(String input){
        return input.equals(" ");
    }

    public boolean isNull(String input){
        return input.isEmpty();
    }

    public boolean isCalculatable(List<String> parsedString){
        boolean numberFlag = true;
        for(String value:parsedString){
            if(numberFlag && isNumber(value)){
                numberFlag = false;
                continue;
            }
            if(!numberFlag && !isNumber(value)){
                numberFlag = true;
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean isCharacterNumber(char variable){
        return variable>='0' && variable<='9';
    }

    public boolean isNumber(String input){
        return Pattern.matches("[0-9]+", input);
    }

}
