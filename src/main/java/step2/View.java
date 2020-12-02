package step2;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double result = calculator.displayResult(scanner.nextLine());
        System.out.println(result);
    }

}
