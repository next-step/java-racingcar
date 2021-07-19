package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CalculationElement<T> {
    private final LinkedList<T> operators;

    private CalculationElement(LinkedList<T> operands) {
        this.operators = operands;
    }

    static <T> CalculationElement<T> from(LinkedList<T> operands) {
        return new CalculationElement<T>(operands);
    }

    int size() {
        return operators.size();
    }

    boolean add(T element) {
        return operators.add(element);
    }

    T poll() {
        if (operators.size() <= 0) {
            throw new NoSuchElementException("queue is empty.");
        }
        return operators.poll();
    }
}
