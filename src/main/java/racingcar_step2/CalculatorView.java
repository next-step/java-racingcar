package racingcar_step2;

public class CalculatorView {
    public static void main(String[] args) {

        String inputString = "2 + 3 * 4 / 2";
        System.out.println("User Input String : " + inputString);

        Calculator calculator = new Calculator(inputString);
        System.out.println("Result Value : " + calculator.getResult());
    }
}