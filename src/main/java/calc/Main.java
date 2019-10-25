package calc;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("계산할 식을 입력하세요. (각 문자열은 공백( )으로 구분)");
        String input = scanner.nextLine();

        Calculator calculator = new Calculator(input);

        System.out.println(calculator.getResult());
    }
}
