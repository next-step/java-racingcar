package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    public static void main(String[] args) {
        //입력값
        String input = "202 + 32 * 40 / 2";
        inputValidate(input);

        String[] actuals = input.split(" ");
        Arrays.stream(actuals).forEach(Calculator::actualValidate);

        List<Integer> numsList = splitNumber(actuals);
        List<String> oprnList = splitOperation(actuals);

        AtomicInteger total = new AtomicInteger();
        total.set(numsList.get(0));

        IntStream.range(1,numsList.size()).forEach( i-> {
            total.set(calculator(total.get(), numsList.get(i), oprnList.get(i - 1)));
        });
        System.out.println("연산결과:"+total);
    }

    public static void inputValidate(String input) {
        if(input.isEmpty() || input == null){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public static void actualValidate(String actual) {
        if(!actual.matches("\\d*") && !actual.matches("[+\\-*/]")){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 값이 입력되었습니다.");
        }
    }

    private static List<Integer> splitNumber(String[] actuals) {
        return Arrays.stream(actuals).filter(num-> num.matches("\\d*")).map(oprn -> Integer.parseInt(oprn)).collect(Collectors.toList());
    }

    private static List<String> splitOperation(String[] actuals) {
        return Arrays.stream(actuals).filter(oprn-> oprn.matches("[+\\-*/]")).collect(Collectors.toList());
    }

    public static int calculator(int num1, int num2, String oprn) {
        if("-".equals(oprn)) return sub(num1,num2);
        if("+".equals(oprn)) return add(num1,num2);
        if("*".equals(oprn)) return multiply(num1,num2);
        if("/".equals(oprn)) return divide(num1,num2);

        return 0;
    }

    private static int sub(int num1, int num2) {
        return num1-num2;
    }

    private static int add(int num1, int num2) {
        return num1+num2;
    }

    private static int multiply(int num1, int num2) {
        return num1*num2;
    }

    private static int divide(int num1, int num2) {
        return num1/num2;
    }

}
