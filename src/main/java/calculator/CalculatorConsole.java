package calculator;

import java.util.Scanner;

public class CalculatorConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();
        while (true){
            try{
                System.out.println("문자열을 입력하세요.(종료: q) \n구분자는 공백(\" \")입니다.");
                String inputValue = scanner.nextLine();
                if(inputValue.equals("q")) break;
                int result = stringCalculator.calculate(inputValue);
                System.out.println("RESULT: " + result);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("=========================");
        }
        System.out.println("프로그램 종료");
    }
}
