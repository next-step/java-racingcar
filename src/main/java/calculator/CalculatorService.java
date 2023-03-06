package calculator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CalculatorService {

    public static void main(String[] args) {

        CalculatorService calculatorService = new CalculatorService();
        Scanner scan = new Scanner(System.in);

        System.out.println("★ 사칙 연산 계산기 ★");
        System.out.print("입력하시오 : ");

        Calculator calculator;

        String calculatorText = scan.nextLine();

        try {
            calculator = calculatorService.calculateLoop(calculatorText);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        System.out.print(calculatorText + " = ");
        System.out.println(calculator.getResult());

    }

    Calculator calculateLoop(String text) {
        Calculator calculator = new Calculator();
        List<String> list = Stream.of(text.split(" "))
                .map(String::trim).collect(Collectors.toList());

        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                calculator = new Calculator(Long.parseLong(list.get(i)));
            }
            else if(i % 2 == 0) {
                numberCheck(list.get(i));
                calculate(calculator, list.get(i - 1), Long.parseLong(list.get(i)));
            }
        }

        return calculator;
    }

    // 숫자인지 체크
    void numberCheck(String number) {
        Boolean isNumber = number.chars().allMatch(( Character::isDigit));

        if(isNumber == false) {
            throw new IllegalArgumentException("숫자가 들어갈 자리입니다.");
        }
    }

    // 사칙연산 계산
    void calculate(Calculator calculator, String operationCode, long number) {

        switch (operationCode) {
            case "+" :
                calculator.addition(calculator.getResult(), number);
                break;
            case "-" :
                calculator.subtraction(calculator.getResult(), number);
                break;
            case "*" :
                calculator.multiplication(calculator.getResult(), number);
                break;
            case "/" :
                calculator.division(calculator.getResult(), number);
                break;
            default:
                throw new IllegalArgumentException("연산자를 확인하십시오.");
        }

    }
}
