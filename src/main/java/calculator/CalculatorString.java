package calculator;
import java.util.Optional;

public class CalculatorString {

    private static final String WHITESPACE= " ";

    public int stringCalculator(String input) {
        String[] strings = stringParser(input);
        int total = Integer.parseInt(strings[0]);
        for (int index = 1; index < strings.length; index += 2) {
            CalculatorSymbol calculatorSymbol = new CalculatorSymbol();
            int secondNum = Integer.parseInt(strings[index + 1]);
            switch (strings[index]) {
                case "+":
                     total  = calculatorSymbol.add(total, secondNum);
                     break;
                case "-":
                    total =   calculatorSymbol.subtract(total, secondNum);
                    break;
                case "*":
                    total =   calculatorSymbol.multiply(total, secondNum);
                    break;
                case "/":
                    total =   calculatorSymbol.division(total, secondNum);
                    break;
                default :
                    throw new IllegalArgumentException("calculatorsymbol is error");
            }
        }
        return total;
    }

    public String[] stringParser(String input) {
        return Optional.ofNullable(input)
                .filter(i -> !i.trim().isEmpty())
                .map(i -> input.split(WHITESPACE))
                .orElseThrow(IllegalArgumentException::new);
    }
}
