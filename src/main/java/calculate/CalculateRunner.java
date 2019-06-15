package calculate;

import java.io.IOException;
import java.util.Scanner;

public class CalculateRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 계산기 : 계산할 수식을 입력해주세요. ex) 1 + 2 * 3 + 4");
        String method = scanner.nextLine();
        System.out.println(method + " = " + Calculator.calculate(method));
        scanner.close();
    }
}
