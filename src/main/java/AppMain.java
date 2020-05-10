import calculator.Calculator;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        String input = "2 + 3 * 4 / 2";

        //Scanner scanner = new Scanner(System.in);
        //System.out.println(scanner.nextLine());

        Calculator calculator = new Calculator(input);
        System.out.println( calculator.getResult() );
    }

}
