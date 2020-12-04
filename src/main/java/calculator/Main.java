package calculator;

import calculator.domain.StringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator(scanner.nextLine());
        System.out.println(stringCalculator.calculate());
    }
}
