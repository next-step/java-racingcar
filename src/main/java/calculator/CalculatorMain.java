package calculator;

public class CalculatorMain {

    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();
        Double resultValue = stringCalculator.calculate("2 + 3 * 5 / 2");
        System.out.println("결과값은 " + resultValue + " 입니다.");
    }

}
