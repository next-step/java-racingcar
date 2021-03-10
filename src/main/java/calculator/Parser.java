package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final Validator validator = new Validator();

    public List<String> parseExpression(String input){
        char[] splitInputArray = input.toCharArray();
        List<String> parsedInputList = new ArrayList<>();
        for(char splitInput:splitInputArray){
            parsedInputList = mergeNumbers(parsedInputList, splitInput);
        }
        return parsedInputList;
    }

    private List<String> mergeNumbers(List<String> parsedString, char splitInput) {
        if(parsedString.isEmpty()){ return pushCharIntoStringList(parsedString, splitInput); }
        String lastParsedString = parsedString.get(parsedString.size()-1);
        if(shouldMerge(lastParsedString, splitInput)){ return mergeCharIntoStringList(parsedString, splitInput); }
        return pushCharIntoStringList(parsedString, splitInput);
    }

    public List<String> pushCharIntoStringList(List<String> stringList, char character){
        stringList.add(String.valueOf(character));
        return stringList;
    }
    
    public List<String> mergeCharIntoStringList(List<String> stringList, char character){
        String tobeMerged = stringList.remove(stringList.size()-1);
        stringList.add(tobeMerged+character);
        return stringList;
    }

    public boolean shouldMerge(String lastParsedString, char splitInput) {
        return validator.isNumber(lastParsedString) & validator.isNumber(String.valueOf(splitInput));
    }


}
