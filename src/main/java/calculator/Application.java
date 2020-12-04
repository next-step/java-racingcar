package calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Utils.checkNullOrEmpty(userInput);

        String[] strings = userInput.split(" ");
        long left = Utils.stringToLong(strings[0]);
        for (int i = 0; i < strings.length - 1; i += 2) {
            String symbol = strings[i + 1];
            long right = Utils.stringToLong(strings[i + 2]);
            left = Calculator.calculate(left, right, symbol);
        }

        System.out.println(left);
    }

}
