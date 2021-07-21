package study.calculator;

import java.util.*;
import java.util.stream.Collectors;

import static study.calculator.Common.*;

public class CalculatorRemake {

    public static int getResult(List<String> values, List<String> operationList) {

        int accumulateNumber = 0;

        for(int j = 0; j< values.size(); j++){
            accumulateNumber = calculateNumber(Integer.parseInt(values.get(j)), operationList, j, accumulateNumber);
        }

        return accumulateNumber;
    }

    private static int calculateNumber(int currentNumber, List<String> operationList,  int j, int accumulateNumber) {

        if(j > 0) {

            String mark = operationList.get(j-1);

            //연산자 설정.
            Operation operation = Operation.chooseOperation(mark);
            //연산 처리 결과 리턴.
            return operation.calculateNumbers(currentNumber, getNextNumber(currentNumber, j, accumulateNumber));
        }
        return currentNumber;
    }

    private static int getNextNumber(int currentNumber, int j, int stackNumber) {
        int nextNumber = j > 1 ? stackNumber : currentNumber;
        return nextNumber;
    }

    public static void start() {
        System.out.println(" 수식을 입력하세요 ex) 2 + 3");

        String[] words = inputValue().split(" ");

        //연산자들을 모음.
        List<String> operations = getFilterbyOperations(words);

        //연한될 변수값들을 모음.
        List<String> values = getFilterbyValues(words);

        System.out.println("result = " + getResult(values, operations));
    }

    private static List<String> getFilterbyValues(String[] words) {
        return Arrays.stream(words)
                //뭔가 더 깔끔한 방법을 모색중.
                .filter(s -> !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
                .collect(Collectors.toList());
    }

    private static List<String> getFilterbyOperations(String[] words) {
        return Arrays.stream(words)
                .filter(s -> s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                .collect(Collectors.toList());
    }
}
