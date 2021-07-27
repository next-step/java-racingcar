package calculator;


import java.util.Arrays;
import java.util.List;


public class Calculator {


    // 사칙연산자 정의
    public static List arithmeticOperations = Arrays.asList("+", "-", "*", "/");


    // input값을 String 배열로 변환하기
    public String[] convertStringToArray(String input){
        if(input != null && input.trim() != ""){
            return input.split(" ");
        } else {
            throw new IllegalArgumentException();
        }
    }


    // 계산하기
    public int calculate(String inputs){
        int result = 0;
        String[] inputArray = convertStringToArray(inputs);
        result = Integer.parseInt(inputArray[0]);


        for (int idx=1; idx < inputArray.length; idx+=2){
            String element = inputArray[idx];
            if(arithmeticOperations.indexOf(element) > -1){
                result = switchOperation(element, result, Integer.parseInt(inputArray[idx+1]));
            } else {
                throw new IllegalArgumentException();
            }
        }


        return result;
    }


    // 연산자에 따라 계산하기
    public int switchOperation(String operation, int num1, int num2) {
        int result = 0;
        switch (operation){
            case "+":
                result = addition(num1, num2);
                break;
            case "-":
                result = subtraction(num1, num2);
                break;
            case "*":
                result = multiplication(num1, num2);
                break;
            default:
                result = division(num1, num2);
        }


        return result;
    }


    // 나누기
    public int division(int num1, int num2) {
        return num1 / num2;
    }


    // 곱하기
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }


    // 빼기
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }


    // 더하기
    public int addition(int num1, int num2) {
        return num1 + num2;
    }


}