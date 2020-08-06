package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DELIMITER = " ";
    private final String expression;

    public Calculator(String expression){
        validInput(expression);
        this.expression = expression;
    }

    public int calculate() {

        String[] splitExpression = splitInput(expression);
        validInteger(splitExpression[0]);

        int result = Integer.parseInt(splitExpression[0]);
        List<Integer> valueList = getValue(splitExpression);
        List<String> operatorList = getOperator(splitExpression);

        for(int i = 0; i < valueList.size() - 1; i++){
            result = Operator.toOperator(operatorList.get(i)).apply(result, valueList.get(i+1));
        }

        return result;
    }

    private void validInput(String input) {
        if(input.trim().isEmpty()){
            throw new IllegalArgumentException("값이 비어있습니다.");
        }
    }

    private String[] splitInput(String input) {
        return input.split(DELIMITER);
    }

    private void validInteger(String str) {
       try {
           Integer.parseInt(str);
       }catch (Exception e) {
           throw new IllegalArgumentException("첫번째 값이 숫자가 아닙니다.");
       }
    }

    private List<Integer> getValue(String[] splitExpression) {
        List<Integer> valueList = new ArrayList<>();
        for(int idx = 0; idx <= splitExpression.length; idx = idx + 2) {
            valueList.add(Integer.parseInt(splitExpression[idx]));
        }
        return valueList;
    }

    private List<String> getOperator(String[] splitExpression) {
        List<String> operatorList = new ArrayList<>();
        for(int idx = 1; idx < splitExpression.length; idx = idx + 2) {
            operatorList.add(splitExpression[idx]);
        }
        return operatorList;
    }

}
