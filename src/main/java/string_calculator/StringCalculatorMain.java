package string_calculator;

import java.util.Scanner;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringCalculator stringCalculator = new StringCalculator();

        System.out.println(stringCalculator.getResult(input, new OperationsDivision()));
    }
}
