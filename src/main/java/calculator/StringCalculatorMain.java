package calculator;

import java.util.Scanner;

//계산 로직을 지니고 있는 StringCalculator 도메인 클래스를 참조해서 계산과 관련되지 않은 책임을 가짐
public class StringCalculatorMain {

    public static void main(String[] args) {
        StringCalculator scal = new StringCalculator();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int result = scal.calculateInfo(input);
        System.out.println(result);
    }
}
