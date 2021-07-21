package study.calculator;

import java.util.*;
import java.util.stream.Collectors;

import static study.calculator.Common.*;
/*
*   코드리뷰 받기 이전 소스.
*/
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

    public static int selectOperation(int num1, String operation, int num2) {

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

    /*
     * 보내주신 리뷰 피드백을 보고 많이 고민했습니다.
     * 일단 알아보기 어려운 자료구조를 변경하려고 고민을 해봤는데요.
     * 별도의 도메인 클래스로 분류를 고려하다가 굳이 이 부분을 어렵게 가져가기 보다는
     * 간결하게 가고 싶어서 steam을 이용한 연산자리스트와 변수리스트를 각각 가져와서
     * 리스트로 변수를 넘기는 방식으로 변경했습니다.
     * CalculatorRemake.start()에서 처리를 하는 식으로 변경했습니다.
     * */
    public static Map<String,List<String>> valueClassification(List<String> wordList) {

        List<String> values = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        for(int i = 0; i< wordList.size(); i++){

            if (isEven(i)) {
                addOperation(wordList.get(i), operations);
            }

            if(!isEven(i)) {
                addValue(wordList.get(i), values);
            }
        }

        Map<String,List<String>> resultMap = new HashMap<>();
        resultMap.put("values",values);
        resultMap.put("values",operations);

        return resultMap;
    }

    private static boolean isEven(int i) {
        return i % 2 == 1;
    }

    private static void addValue(String value, List<String> values) {
        checkValue(value);
        values.add(value);
    }

    private static void addOperation(String value, List<String> operationList) {
        checkOperation(value);
        operationList.add(value);
    }

    public static int getResult(List<String> values, List<String> operationList) {

        int result = 0;

        for(int j = 0; j< values.size(); j++){

            if(j > 0){

                int cumulativeValue = j > 1 ? result : Integer.parseInt(values.get(0));
                result = Calculator.selectOperation(cumulativeValue, operationList.get(j-1),Integer.parseInt(values.get(j)));

            }
        }
        return result;
    }

    public static void start() {
        System.out.println(" 수식을 입력하세요 ex) 2 + 3");

        Map<String,List<String>> map = valueClassification(Arrays.asList(inputValue().split(" ")));
        System.out.println("result = " + getResult(map.get("values"), map.get("values")));
    }
}
