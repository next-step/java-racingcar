import project.InputTool;
import project.calculator.Calculator;
import project.calculator.NumberType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputTool inputTool = new InputTool();

        String result = Calculator.calculateForString(inputTool.readLine(), NumberType.INTEGER);

        System.out.println(result);
    }
}
