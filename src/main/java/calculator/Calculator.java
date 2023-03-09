package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    final static String DELIMITER = " ";

    public void start() {
        //입력값
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산기입력 : ");
        String input = scanner.nextLine(); //"202 + 32 * 40 /
        scanner.close();

        inputValidate(input);

        String[] actuals = input.split(DELIMITER);
        Arrays.stream(actuals).forEach(actual -> {actualValidate(actual);});

        List<Integer> numsList = splitNumber(actuals);
        List<String> operationList = splitOperation(actuals);

        if(numsList.size()-1 != operationList.size()){
            throw new IllegalArgumentException("연산기호와 숫자의 갯수가 맞지않습니다.");
        }

        int result = getResult(numsList, operationList);
        System.out.println("연산결과:"+result);
    }

    public void inputValidate(String input) {
        if(input.isEmpty() || input.isBlank()){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void actualValidate(String actual) {
        if(!actual.matches("\\d*") && !actual.matches("[+\\-*/]")){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 값이 입력되었습니다.");
        }
    }

    private List<Integer> splitNumber(String[] actuals) {
        return Arrays.stream(actuals).filter(number-> number.matches("\\d*")).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
    }

    private List<String> splitOperation(String[] actuals) {
        return Arrays.stream(actuals).filter(operation-> operation.matches("[+\\-*/]")).collect(Collectors.toList());
    }

    public int calculate(int num1, int num2, String operation) {
        switch (operation){
            case "-": return sub(num1,num2);
            case "+": return add(num1,num2);
            case "*": return multiply(num1,num2);
            case "/": return divide(num1,num2);
            default:
                return 0;
        }
    }

    public int getResult(List<Integer> numsList, List<String> operationList) {
        var result = numsList.get(0);
        for(var i = 1; i< numsList.size(); i++){
            result = calculate(result, numsList.get(i), operationList.get(i - 1));
        }
        return result;
    }

    private int sub(int num1, int num2) {
        return num1-num2;
    }

    private int add(int num1, int num2) {
        return num1+num2;
    }

    private int multiply(int num1, int num2) {
        return num1*num2;
    }

    private int divide(int num1, int num2) {
        return num1/num2;
    }
}
