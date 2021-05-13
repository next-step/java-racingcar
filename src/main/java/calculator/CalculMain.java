package calculator;

import java.util.Scanner;

public class CalculMain {

    public static void main(String[] args){

        Calculator calculator = new Calculator();
        String userInput = "2 + 3 * 4 / 2";
        calculator.setUserInput(userInput);

        System.out.println(calculator.caculateUserInput());

    }
}
