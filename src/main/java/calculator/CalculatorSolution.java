package calculator;

import calculator.exception.InvalidFormulaException;

import java.util.Scanner;

public class CalculatorSolution {
    public static void main(String[] args) {
        CalculatorSolution calculatorSolution = new CalculatorSolution(
                new StringCalculator()
        );
        calculatorSolution.run();
    }

    private Calculator calculator;
    public CalculatorSolution(Calculator calculator) {
        this.calculator = calculator;
    }

    private Scanner scanner = new Scanner(System.in);
    private void run() {
        String input;
        while(!(input = requestInput()).equals("Q")) {
            try {
                System.out.println("계산 결과 : " + calculator.calculation(input));
            } catch (InvalidFormulaException | IllegalArgumentException | ArithmeticException e) {
                System.out.println("[오류 발생] " + e.getMessage());
            }
        }
    }

    private String requestInput() {
        System.out.println("---------------------------");
        System.out.println("연산을 수행할 문자열을 입력 해주세요");
        System.out.println("종료를 원하시면 Q를 입력 해주세요.");
        System.out.println("---------------------------");
        return scanner.nextLine();
    }
}
