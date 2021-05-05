package calculaor;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    // 변수 지정
    private static final String spiltValue = " ";

    // 기능 구현 목록
    // input 값
    private String[] inputValue(String input) {
        return input.split(spiltValue);
    }

    // 1. 사칙연산 기능
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    public int div(int a, int b) {
        return a / b;
    }

    // 2. 사칙연산 기호 평가하기
    public String operatorevaluation(int num1, int num2, String operator) {
        // operatorList 만들기
        Map<String, String> operatorList = new HashMap<String, String>();
        operatorList.put("+", Integer.toString(add(num1,num2)));
        operatorList.put("-", Integer.toString(sub(num1,num2)));
        operatorList.put("*", Integer.toString(mul(num1,num2)));
        operatorList.put("/", Integer.toString(div(num1,num2)));

        // operator 판단하기
        String evaluation = null;
        if (operatorList.containsKey(operator)) {
            evaluation = operatorList.get(operator);
        }
        return evaluation;
    }

    // 3. 사칙연산 실행
    public String calculation(String input) {
        Calculator calculator = new Calculator();
        String[] testValue = calculator.inputValue(input);
        String lastCalculationValue;

        for (int i = 0; i < testValue.length - 1; i++) {
            if (i % 2 == 1) {
                int num1 = Integer.parseInt(testValue[i - 1]);
                int num2 = Integer.parseInt(testValue[i + 1]);
                String operator = testValue[i];

                lastCalculationValue = calculator.operatorevaluation(num1, num2, operator);
                testValue[i + 1] = lastCalculationValue;
            }
        }
        return testValue[(testValue.length - 1)];
    }
}
