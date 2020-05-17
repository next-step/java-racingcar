package calculator;

public class CalculatorString {

    CalculatorSymbol calculatorSymbol = CalculatorSymbol.getInstance();
    ParserUtils parserUtils = ParserUtils.getInstance();

    public int calculate(String input) {

        String[] strings = parserUtils.toArray(input);
        int total = parserUtils.getNumber(strings, 0);

        for (int index = 1; index < strings.length; index += 2) {
            total = calculatorSymbol.findTypeAndCalculator(total, parserUtils.getNumber(strings, index + 1), strings[index]);
        }
        return total;
    }
}
