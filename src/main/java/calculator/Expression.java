package calculator;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {

    private static final String SPACE = " ";

    private String mRawExpression;
    private NumberType mNumberType;
    private Queue<Number> mNumbers;
    private Queue<OperatorType> mOperators;

    public Expression(@NotNull String rawExpression, NumberType numberType) {
        this.mRawExpression = rawExpression;
        this.mNumberType = numberType;
        this.mNumbers = new LinkedList<>();
        this.mOperators = new LinkedList<>();

        parse(mRawExpression);
    }

    private void parse(String rawExpression) {
        String[] splitExpression = splitFromSpace(rawExpression);
        parseByElementType(splitExpression);
    }

    private String[] splitFromSpace(@NotNull String text) {
        return text.split(SPACE);
    }

    private void parseByElementType(String[] splitExpression) {
        for (String each : splitExpression) {
            addElement(each);
        }
    }

    private void addElement(String elementString) {
        if (ValidationUtils.isNumeric(elementString)) {
            addNumber(elementString);
            return;
        }

        if (OperatorType.find(elementString) != null) {
            addOperator(elementString);
            return;
        }

        throw new IllegalArgumentException("유효하지 않은 수식입니다.");
    }

    private void addNumber(String numberString) {
        switch (mNumberType) {
            case INTEGER:
                mNumbers.add(new IntegerNumber(numberString));
                break;

            case DECIMAL:
                mNumbers.add(new DecimalNumber(numberString));
                break;
        }
    }

    private void addOperator(String operatorString) {
        mOperators.add(OperatorType.find(operatorString));
    }

    public Number getNextNumber() {
        return mNumbers.poll();
    }

    public OperatorType getNextOperator() {
        return mOperators.poll();
    }
}
