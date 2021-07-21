import calculator.Calculator;
import calculator.Formula;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Formula("2 + 3 * 4 / 2"));
        int result = calculator.calculate();
        System.out.println("result : " + result);
    }
}
