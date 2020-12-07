package step2;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathematicalExpression {

    private Numbers numbers;
    private Operators operators;
    private int operationCount;

    public MathematicalExpression(List<BigDecimal> numbers, List<Operator> operators) {
        if (numbers.size() - 1 != operators.size()) {
            throw new IllegalArgumentException();
        }
        this.numbers = new Numbers(numbers);
        this.operators = new Operators(operators);
        this.operationCount = this.operators.size();
    }

    public static MathematicalExpression of(String text) {
        String[] splitText = checkValidAndReturnSplitText(text);
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

    public int getOperationCount() {
        return operationCount;
    }

    public BigDecimal getNumber(int index) {
        return numbers.get(index);
    }

    public Operator getOperator(int index) {
        return operators.get(index);
    }

    private static BigDecimal textToBigDecimal(String text) {
        if (!isNumeric(text)) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(text);
    }

    private static String[] checkValidAndReturnSplitText(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String[] splitText = text.split(" ");
        if (splitText.length == 1) {
            throw new IllegalArgumentException();
        }
        return splitText;
    }

    private static boolean isNumeric(String strNum) {
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
