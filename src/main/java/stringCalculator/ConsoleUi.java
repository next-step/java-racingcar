package stringCalculator;

import java.util.Scanner;

public class ConsoleUi {

    Scanner sc;
    Calculator calculator;
    Double result;

    public ConsoleUi() {
        System.out.println("문자열 사칙 연산기");
        System.out.println("문자열을 입력하세요 > ");
        sc = new Scanner(System.in);
    }

    public void start() {
        calculator = new Calculator(sc.nextLine());
        this.result = calculator.work();
        printResult();
    }

    public void printResult() {
        System.out.println("결과 : " + trimDecimalZeroResult(this.result));
    }

    public String trimDecimalZeroResult(double input) {
        if ((int) input == input) {
            return String.valueOf((int) input);
        }
        return String.valueOf(input);
    }


}
