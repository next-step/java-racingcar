package calculator;

public class TextCalculator {
    public static int calculate(String input) {
        CalcNumbers calcNumbers = new CalcNumbers(Text.input(input).elements());
        return new Operator(calcNumbers).sum();
    }
}
