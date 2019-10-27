import step1.calculator.StringCalculator;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Not found arguments");
        }
        String type = args[0];
        String equation = args[1];

        System.out.println(new StringCalculator<>(type).calculate(equation));
    }
}
