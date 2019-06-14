package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringCalculator stringCalculator = new StringCalculator();

        stringCalculator.isNotEmpty(input);

        String[] strings = input.split(" ");

        int result = stringCalculator.calculate(strings);
        System.out.println(result);

        sc.close();
    }

}
