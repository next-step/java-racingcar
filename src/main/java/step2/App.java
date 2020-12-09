package step2;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("계산기 프로그램을 시작합니다.");
        Calculator calculator = new Calculator(InputHandler.getMathematicalExpression());
        BigDecimal result = calculator.calculate();
        System.out.println("계산 결과는 : " + result.toString() + "입니다.");
    }

}
