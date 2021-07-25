package stringcalculator;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StringCalculator cal = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("입력한 계산식 : " + cal.calculate(input));
    }
}
