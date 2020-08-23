package stringcalculator;

import java.util.Scanner;
import static stringcalculator.Constants.INSTRUCTION;
import static stringcalculator.Constants.INPUT_CONSOLE;
import static stringcalculator.Constants.OUTPUT_CONSOLE;
import static stringcalculator.util.StringCalculator.*;

public class StringCalView {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(INSTRUCTION);
        System.out.print(INPUT_CONSOLE);
        String expression = scanner.nextLine();
        System.out.print(OUTPUT_CONSOLE + calculate(expression));
    }
}