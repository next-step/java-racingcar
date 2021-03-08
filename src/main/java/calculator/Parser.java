package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final Validator validator = new Validator();

    public List<String> parseExpression(String input){
        List<String> parsedString = new ArrayList<>();
        String stringedNumber = "";
        for(int idx = 0;idx<input.length();idx++){
            char charAtIdx = input.charAt(idx);
            if(validator.isCharacterNumber(charAtIdx)){
                stringedNumber+=charAtIdx;
                continue;
            }
            if(stringedNumber.isEmpty()){
                parsedString.add(String.valueOf(charAtIdx));
                continue;
            }
            parsedString.add(stringedNumber);
            stringedNumber = "";
            parsedString.add(String.valueOf(charAtIdx));
        }
        if(!stringedNumber.isEmpty()){
            parsedString.add(stringedNumber);
        }
        return parsedString;
    }
}
