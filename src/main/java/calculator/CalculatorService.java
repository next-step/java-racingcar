package calculator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CalculatorService {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);

        System.out.println("★ 사칙 연산 계산기 ★");
        System.out.print("입력하시오 : ");

        String calculatorText = scan.nextLine();

        try {
            calculateLoop(calculatorText, calculator);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        System.out.print(calculatorText + " = ");
        System.out.println(calculator.result);

    }

    static void calculateLoop(String text, Calculator calculator) {
        List<String> list = Stream.of(text.split(" "))
                .map(String::trim).collect(Collectors.toList());

        for(int i=0; i < list.size(); i++) {
            if(i==0) {
                calculator.result = Long.parseLong(list.get(i));
            }
            else if(i%2==0) {
                numberCheck(list.get(i));
                calculate(calculator, list.get(i - 1), Long.parseLong(list.get(i)));
            }
        }
    }

    // 숫자인지 체크
    static void numberCheck(String number) {
        Boolean isNumber = number.chars().allMatch(( Character::isDigit));
        if(isNumber == false) {
            throw new IllegalArgumentException();
        }
    }

    // 사칙연산 계산
    static void calculate(Calculator calculator, String operationCode, long number) {

        switch (operationCode) {
            case "+" :
                calculator.addition(number);
                break;
            case "-" :
                calculator.subtraction(number);
                break;
            case "*" :
                calculator.multiplication(number);
                break;
            case "/" :
                calculator.division(number);
                break;
            default:
                throw new IllegalArgumentException();
        }

    }
}
