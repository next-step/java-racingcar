package step1;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        System.out.println("연산하고 싶은 문자열을 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();

        String result = runCalculatorApplication(inputString);
        System.out.println("연산 결과 : " + result);
    }

    public static String runCalculatorApplication(String inputString) {

        try {
            Operator operator = new Operator();
            return operator.operate(inputString);
        } catch (IllegalArgumentException e) {
            return "공백을 입력하셨거나, 연산자 기호가 아닌 기호를 입력하셨습니다.";
        } catch (ArithmeticException e) {
            return "0으로 나눌 수 없습니다.";
        }
    }

}
