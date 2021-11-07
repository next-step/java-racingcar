package stringcalculator.console;


import stringcalculator.arithmeticcomponent.ArithmeticResult;

/**
 * 수식의 연산결과를 출력하기위한 콘솔
 */
public class OutputConsole {

    private OutputConsole() {
    }

    public static void printExpression(ArithmeticResult arithmeticResult) {
        System.out.println(String.format("= %d", arithmeticResult.number()));
    }
}
