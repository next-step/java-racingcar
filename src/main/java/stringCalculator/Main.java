package stringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();

        System.out.println("결과는 " + new StringCalculator().calculate(formula));
    }
}
