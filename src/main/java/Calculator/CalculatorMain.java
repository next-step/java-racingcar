package Calculator;

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class CalculatorMain {

    public static void main(String[] args) {
        Integer result;
        Scanner sc = new Scanner(System.in);

        System.out.println("계산하고 싶은 수식을 입력해주세요.");
        System.out.println("ex) 2 + 3 * 4 / 2");
        System.out.print("입력 : ");

        Calculator calculator = new Calculator(sc.nextLine());

        try {
            result = calculator.execute();
            System.out.println("결과 : " + result);
        } catch (NumberFormatException e) {
            System.out.println("숫자 위치에 다른 문자가 존재합니다. \n" + e.getMessage());
        } catch (IllegalArgumentException | DataFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
