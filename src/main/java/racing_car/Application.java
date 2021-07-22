package racing_car;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Calculator calculator = new Calculator();
        try {
            int calculate = calculator.calculate(input);
            System.out.println(calculate);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력하세요");
        }

    }
}
