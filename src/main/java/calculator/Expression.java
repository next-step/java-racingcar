package calculator;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Expression {

    private static final String SPACE = " ";

    private NumberType mNumberType;
    private Queue<String> mElements;

    public Expression(@NotNull String rawExpression, NumberType numberType) {
        this.mNumberType = numberType;
        this.mElements = new LinkedList<>();
        parse(rawExpression);
    }

    private void parse(String rawExpression) {
        String[] splitExpression = splitFromSpace(rawExpression);
        addToElement(splitExpression, mElements);
    }

    private String[] splitFromSpace(@NotNull String text) {
        return text.split(SPACE);
    }

    private void addToElement(String[] splitExpression, Queue<String> elements) {
        elements.addAll(Arrays.asList(splitExpression));
    }

    public Queue<String> getElements() {
        return mElements;
    }
}
