package calculator;

import java.util.Scanner;

import static calculator.CalculatorConsole.Console.println;

public class CalculatorConsole {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        while (true){
            try{
                String inputValue = Console.input();
                if(inputValue.equals("q")) {
                    break;
                }
                println("결과: " + stringCalculator.calculate(inputValue));
            }catch (Exception e){
                println(e.getMessage());
            }
            println("======================================");
        }
        println("프로그램 종료");
    }

    static class Console {
        private static Scanner scanner = new Scanner(System.in);

        public static String input(){
            println("문자열을 입력하세요.(종료:q, 구분자는 공백입니다.)");
            return scanner.nextLine();
        }

        public static void println(String text){
            System.out.println(text);
        }
    }
}
