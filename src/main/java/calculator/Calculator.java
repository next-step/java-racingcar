package calculator;

import java.util.List;

public class Calculator {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();

    public int calculate(String input){
        if(!validator.isInputBlankSafe(input)) throw new IllegalArgumentException();
        List<String> parsedInput = parser.parseExpression(input);
        if(!validator.isCalculatable(parsedInput)) throw new IllegalArgumentException();
        return runCalculator(parsedInput);
    }

    public int runCalculator(List<String> parsedInput) {
        int calculatedValue = Integer.parseInt(parsedInput.get(0));
        for(int idx = 1;idx<parsedInput.size();idx+=2){
            String operator = parsedInput.get(idx);
            int operand = Integer.parseInt(parsedInput.get(idx+1));
            calculatedValue = calculateUnit(calculatedValue, operator, operand);
        }
        return calculatedValue;
    }

    public int calculateUnit(int baseNumber, String operator, int operand){
        if(operator.equals("+")){ return baseNumber + operand; }
        if(operator.equals("-")){ return baseNumber - operand; }
        if(operator.equals("*")){ return baseNumber * operand; }
        if(operator.equals("/")){ return baseNumber / operand; }
        throw new IllegalArgumentException();
    }


}
