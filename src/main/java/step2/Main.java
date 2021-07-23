package step2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FIFOCalculator calculator = new FIFOCalculator(new Scanner(System.in).nextLine());

        try {
            int result = calculator.calculate();

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
}
