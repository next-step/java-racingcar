package step2;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double result = 0;

        for (String s : scanner.nextLine().split(" ")) {
            result = calculator.calculate(result, s);
        }

        System.out.println(result);
    }

}
