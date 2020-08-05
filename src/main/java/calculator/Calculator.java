package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {

    private final String expression;

    public Calculator(String expression){
        validInput(expression);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public int calculate() {

        String[] splitExpression = splitInput(expression);
        validInteger(splitExpression[0]);

        AtomicInteger result = new AtomicInteger(Integer.parseInt(splitExpression[0]));
        List<Integer> valueList = getValue(splitExpression);
        List<String> operatorList = getOperator(splitExpression);

        for(int i=0;i<valueList.size()-1;i++){
            result.set ( cal(result.get(), valueList.get(i+1), operatorList.get(i)) );
            System.out.println("==>"+result.get());
        }

        return result.get();
    }

    // 유효성 검사
    public void validInput(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("값이 비어있습니다.");
        }
    }

    public String[] splitInput(String input) {
        return input.split(" ");
    }

    public void validInteger(String str) {
       try {
           Integer.parseInt(str);
       }catch (Exception e) {
           throw new IllegalArgumentException("첫번째 값이 숫자가 아닙니다.");
       }
    }

    public List<Integer> getValue(String[] splitExpression) {
        List<Integer> valueList = new ArrayList<>();
        for(int idx=0;idx<=splitExpression.length;idx=idx+2) {
            valueList.add(Integer.parseInt(splitExpression[idx]));
        }
        return valueList;
    }

    public List<String> getOperator(String[] splitExpression) {
        List<String> operatorList = new ArrayList<>();
        for(int idx=1;idx<splitExpression.length;idx=idx+2) {
            operatorList.add(splitExpression[idx]);
        }
        return operatorList;
    }

    public int cal(int atomic, int value, String operator) {
        AtomicInteger result = new AtomicInteger();
        switch (operator) {
            case "+": result.set(atomic + value); break;
            case "-": result.set(atomic - value); break;
            case "*": result.set(atomic * value); break;
            case "/": result.set(atomic / value); break;
            default: break;
        }

        return result.get();
    }

}
