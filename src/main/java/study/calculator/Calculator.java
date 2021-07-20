package study.calculator;

import java.util.*;

import static study.calculator.Common.*;

public class Calculator {

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divisionShare(int num1, int num2) {
        return num1 / num2;
    }

    public static int divisionRemainder(int num1, int num2) {
        return num1 % num2;
    }

    public static int getOperation(int num1, String operation, int num2) {

        int result = 0;

        switch (operation) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divisionShare(num1, num2);
                break;
            default:
                System.out.println("수식이 없습니다.");
                break;
        }

        return result;
    }

    public static Map<String,List<String>> valueClassification(List<String> wordList) {
        List<String> valueList = new ArrayList<>();
        List<String> operationList = new ArrayList<>();

        for(int i = 0; i< wordList.size(); i++){
            
            if (isEven(i)) {
                addOperation(wordList.get(i), operationList);
            }

            if(!isEven(i)) {
                addValue(wordList.get(i), valueList);
            }
        }

        Map<String,List<String>> resultMap = new HashMap<>();
        resultMap.put("values",valueList);
        resultMap.put("operations",operationList);

        return resultMap;
    }

    private static boolean isEven(int i) {
        return i % 2 == 1;
    }

    private static void addValue(String value, List<String> valueList) {
        checkValue(value);
        valueList.add(value);
    }

    private static void addOperation(String value, List<String> operationList) {
        checkOperation(value);
        operationList.add(value);
    }

    public static int getResult(List<String> valueList, List<String> operationList) {

        int result = 0;

        for(int j = 0; j< valueList.size(); j++){

            if(j>0){

                int cumulativeValue = j > 1 ? result : Integer.parseInt(valueList.get(0));

                result = Calculator.getOperation(cumulativeValue, operationList.get(j-1),Integer.parseInt(valueList.get(j)));
            }
        }
        return result;
    }

    public static void start() {
        System.out.println(" 수식을 입력하세요 ex) 2 + 3");
        Map<String,List<String>> map = valueClassification(Arrays.asList(inputValue().split(" ")));
        System.out.println("result = " + getResult(map.get("values"), map.get("operations")));
    }
}
