package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        System.out.println("사칙연산 계산기 : 입력값을 공백으로 구분해주세요");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        InputVo inputVo = new InputVo(input);
        Calculator calculator = new Calculator(inputVo.getInputSplit());

        System.out.println("결과 : " + calculator.calculateUserInput());
    }
}
