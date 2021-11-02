package Calculator;

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class CalculatorMain {

    public static void main(String[] args) throws DataFormatException {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("계산하고 싶은 수식을 입력해주세요.");
        System.out.println("ex) 2 + 3 * 4 / 2");
        System.out.print("입력 : ");

        Integer result = calculator.calculate(sc.nextLine());
        System.out.println("결과 : " + result);
    }
}
