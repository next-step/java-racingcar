package calculator;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {

    private static final String SPACE = " ";

    private String mRawExpression;
    private NumberType mNumberType;
    private Queue<String> mElements;

    public Expression(@NotNull String rawExpression, NumberType numberType) {
        this.mRawExpression = rawExpression;
        this.mNumberType = numberType;
        this.mElements = new LinkedList<>();
    }

    private void parse(String rawExpression) {
        String[] splitExpression = splitFromSpace(rawExpression);
        addToElement(splitExpression, mElements);
    }

    private String[] splitFromSpace(@NotNull String text) {
        return text.split(SPACE);
    }

    private void addToElement(String[] splitExpression, Queue<String> elements) {
        for (String each : splitExpression) {
            validate(each);
            elements.add(each);
        }
    }

    private void validate(String element) {
        if (!ValidationUtils.isNumeric(element) && OperatorType.find(element) == null) {
            throw new IllegalArgumentException("유효하지 않은 수식입니다. 입력 규칙을 지켜주세요.");
        }
    }

    public Queue<String> getElements() {
        parse(mRawExpression);
        return mElements;
    }
}
