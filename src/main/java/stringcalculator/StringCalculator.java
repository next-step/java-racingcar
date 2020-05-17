package stringcalculator;

public class StringCalculator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No args");
            return;
        }
        String expression = String.join(" ", args);
        StringCalculator calculator = new StringCalculator();
        System.out.println(expression + " = " + calculator.calculate(expression));
    }

    int calculate(String str) {
        return new StringExpression(str).getResult();
    }
}
