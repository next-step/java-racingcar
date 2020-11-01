package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private static final Map<String,String> groupToRegexMap = new HashMap<>();

    public StringCalculator() {
        groupToRegexMap.put("number","^[0-9]*$");
        groupToRegexMap.put("sp","^[^a-zA-Z0-9가-힣]");
    }

    private String getType(String input) {
        return groupToRegexMap.entrySet()
                .stream()
                .filter(entry -> input.matches(entry.getValue()))
                .map(entry -> entry.getKey())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 또는 연산자만 입력가능합니다"));
    }

    private void isEmpty(String value) {
        if(value == null || value.isEmpty() || value.trim().length() == 0) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자 입니다");
        }
    }

    private void expressionCheck(String[] valueArr) {

        if(!getType(valueArr[0]).equals("number")) {
            throw new IllegalArgumentException("첫번째 문자열이 숫자가 아닙니다");
        }

        if(getType(valueArr[valueArr.length-1]).equals("sp")) {
            throw new IllegalArgumentException("마지막 문자열이 연산자로 끝납니다");
        }
    }

    private String[] split(String expression) {
        isEmpty(expression);
        String expArr[] = expression.split(" ");
        expressionCheck(expArr);

        return expArr;
    }

    public int result(String input) {
        String inputArr[] = split(input);

        int resultNum = Integer.parseInt(inputArr[0]);

        for (int i = 1; i < inputArr.length; i += 2) {
            String op = inputArr[i];
            int secondNum = Integer.parseInt(inputArr[i + 1]);
            resultNum = Calculrator.operation(resultNum,secondNum,op);
        }

        return resultNum;
    }

}
