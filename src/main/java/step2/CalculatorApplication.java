package step2;

import java.util.Scanner;

public class CalculatorApplication {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("String Sum Calculator");
        System.out.println("Basic Delimiters are \",\" and \";\"");
        System.out.println("Enter \"//\" and \"\\n\" followed by your custom delimiter, if wanted (ex. \"//;\\n1;2;3\")");
        System.out.println("Enter the String below (ex. \"1,2,3\")");
        String input = SCANNER.nextLine();
        StringSumCalculator stringSumCalculator = new StringSumCalculator();
        int result = stringSumCalculator.calculateStringWithSumOnly(input);
        System.out.println("result : " + result);
    }
}
