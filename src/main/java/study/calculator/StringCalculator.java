package study.calculator;

import java.util.LinkedList;

public class StringCalculator {


    public static String getCalculationResult(String toCalculateValue){
        isEmptyInput(toCalculateValue);

        String[] input = toCalculateValue.split(" ");

        LinkedList<Integer> operand = new LinkedList<Integer>();
        LinkedList<String> operator = new LinkedList<String>();

        //입력값을 연산자와 피연산자로 분리
        int inputLength = input.length;

        for(int i=0; i<inputLength; i++){
            if(i%2 == 0){
                isNumericString(input[i]);
                operand.add(Integer.parseInt(input[i]));
            }else{
                isCorrectOperator(input[i]);
                operator.add(input[i]);

            }
        }

        int calculationResult = 0;
        int operandSize = operand.size();
        int operatorSize = operator.size();

        //입력값이 정상적으로 완성되지 않은 경우
        if(operandSize != operatorSize+1){
            throw new IllegalArgumentException("입력값이 정상적으로 종료되지않았습니다.");
        }

        for(int j=0; j<operandSize; j++){
            if(j == operandSize - 1){
                break;
            }else{
                CalculateSet calculateSet;
                if(j == 0){
                    calculateSet = new CalculateSet(operand.get(j), operand.get(j+1));
                }else{
                    calculateSet = new CalculateSet(calculationResult, operand.get(j+1));
                }
                calculationResult = calculate(calculateSet, operator.get(j));
                
            }
        }
        
        return String.valueOf(calculationResult);
    }

    private static int calculate(CalculateSet calculateSet, String operator) {
        int innerResult = 0;

        switch (operator) {
            case "+":
                innerResult = getAddition(calculateSet.left, calculateSet.right);
                break;
            case "-":
                innerResult = getSubtraction(calculateSet.left, calculateSet.right);
                break;
            case "*":
                innerResult = getMultiplication(calculateSet.left, calculateSet.right);
                break;
            case "/":
                innerResult = getDivision(calculateSet.left, calculateSet.right);
                break;
            default:
                break;
        }

        return innerResult;
    }

    private static int getDivision(int left, int right) {
        if(right == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return  left / right;
    }

    private static int getMultiplication(int left, int right) {
        return left * right;
    }

    private static int getSubtraction(int left, int right) {
        return left - right;
    }

    private static int getAddition(int left, int right) {
        return  left + right;
    }

    private static void isCorrectOperator(String input) {
        if(!input.matches("([+\\-*\\/])")){
            throw new IllegalArgumentException("연산자는 (+,-,*,/)만 사용 가능합니다.");
        }
    }

    private static void isNumericString(String input) {
        if(!input.matches("-?\\d+")){
            throw new IllegalArgumentException("피연산자는 정수형 숫자로 입력하세요.");
        }
    }


    private static void isEmptyInput(String input) {
        if(input == null || input.length() == 0 || input.trim().length() == 0){
            throw new IllegalArgumentException("빈값을 입력하실 수 없습니다.");
        }
    }
}
