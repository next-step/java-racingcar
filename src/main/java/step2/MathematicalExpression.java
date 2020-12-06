package step2;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathematicalExpression {

    private List<BigDecimal> numbers;
    private List<Operator> operators;

    public MathematicalExpression(List<BigDecimal> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static MathematicalExpression of(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String[] splitText = text.split(" ");
        if (splitText.length == 1) {
            throw new IllegalArgumentException();
        }
        List<BigDecimal> numbers = IntStream.range(0, splitText.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> textToBigDecimal(splitText[i]))
                .collect(Collectors.toList());
        List<Operator> operators = IntStream.range(0, splitText.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> Operator.getOperatorFor(splitText[i]))
                .collect(Collectors.toList());
        return new MathematicalExpression(numbers, operators);
    }

    public BigDecimal getNumber(int index) {
        return numbers.get(index);
    }

    public Operator getSymbol(int index) {
        return operators.get(index);
    }

    private static BigDecimal textToBigDecimal(String text) {
        if (!isNumeric(text)) {
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
