package step2;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathematicalExpression {

    private static final String SEPARATOR = " ";

    private Numbers numbers;
    private Operators operators;
    private int operationCount;

    private MathematicalExpression(List<String> numberText, List<String> operatorText) {
        this.numbers = new Numbers(numberText);
        this.operators = new Operators(operatorText);
        this.operationCount = this.operators.size();
    }

    public static MathematicalExpression of(String text) {
        ValidationUtil.checkValidation(text);
        return new MathematicalExpression(
                StringUtil.toEvenIndexList(text, SEPARATOR),
                StringUtil.toOddIndexList(text, SEPARATOR));
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


}
