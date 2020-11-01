package study1.step2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final Map<String, Operator> operator = new HashMap<>();;

    static{
        for(Operation op: Operation.values()){
            operator.put(op.getOperationSymbol(), op);
        }
    }
    public int calculate(String input){
        // calculate의 split을 따로 함수를 파고 여기서 null check를 하여 raise 시키자
        inputValidation(input);
        String[] inputList = input.split(" ");


        int result = Integer.parseInt(inputList[0]);
        for(int i = 1; i < inputList.length; i++){
            if(operatorCheck(i, inputList[i])){
                Operator operation = operator.get(inputList[i]);
                result = operation.calculate(result, Integer.parseInt(inputList[i+1]));
            }
        }
        return result;
    }

    private boolean operatorCheck(int index, String operationSymbol){
        if (!operator.containsKey(operationSymbol)){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        return index%2 == 1;
    }

    private void inputValidation(String input){
        if(inputNullCheck(input) || inputValueCheck(input)){
            throw new IllegalArgumentException("입력값 확인해주세요");
        }
    }

    private boolean inputNullCheck(String input){
        return input == null;
    }
    private boolean inputValueCheck(String input) {
        return "".equals(input.trim());
    }
}
