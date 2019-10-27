import calculator.Calculator;
import calculator.InputTool;
import calculator.NumberType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputTool inputTool = new InputTool(new Scanner(System.in));

        String result = Calculator.calculateForString(inputTool.readLine(), NumberType.INTEGER);

        System.out.println(result);
    }
}
