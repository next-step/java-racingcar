package step2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathematicalExpression {

    private List<BigDecimal> numbers;
    private List<Symbol> symbols;

    public MathematicalExpression(List<BigDecimal> numbers, List<Symbol> symbols) {
        this.numbers = numbers;
        this.symbols = symbols;
    }

    public static MathematicalExpression of(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String[] splitText = text.split(" ");
        List<BigDecimal> numbers = IntStream.range(0, splitText.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> textToBigDecimal(splitText[i]))
                .collect(Collectors.toList());
        List<Symbol> symbols = IntStream.range(0, splitText.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> new Symbol(splitText[i]))
                .collect(Collectors.toList());
        return new MathematicalExpression(numbers, symbols);
    }

    public BigDecimal getNumber(int index) {
        return numbers.get(index);
    }

    public Symbol getSymbol(int index) {
        return symbols.get(index);
    }

    private static BigDecimal textToBigDecimal(String text) {
        if (isNumeric(text)) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(text);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
