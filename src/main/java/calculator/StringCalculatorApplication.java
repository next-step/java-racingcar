package calculator;

import java.util.Scanner;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        String result = stringCalculator.execute(input);


        System.out.println("result :" + result);
    }
}
