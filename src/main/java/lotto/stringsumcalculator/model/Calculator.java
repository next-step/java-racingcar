package lotto.stringsumcalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int calculate(String inputString){

        if(inputString.isEmpty()) inputString = "0";

        String pattern = "(//.*\\\\n)(.*)";
        Matcher matcher = Pattern.compile(pattern).matcher(inputString);
        Separators separators = new Separators();;
        String stringOprands = inputString;

        if(matcher.find()) {
            separators = new Separators(matcher.group(1));
            stringOprands = matcher.group(2);
        }

        return sum(new Operands(stringOprands, separators));
    }

    public static int sum(Operands operands){
        int result = 0;
        for (int i = 0; i < operands.getCount(); i++) {
            result += operands.getOperand(i).getValue();
        }

        return result;
    }


}
