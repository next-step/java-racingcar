package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class CalculationElement<T> {
    private final LinkedList<T> operators;

    private CalculationElement(LinkedList<T> operands) {
        this.operators = operands;
    }

    public static <T> CalculationElement<T> from(LinkedList<T> operands) {
        return new CalculationElement<T>(operands);
    }

    public int size() {
        return operators.size();
    }

    public boolean add(T element) {
        return operators.add(element);
    }

    public T poll() {
        if (operators.size() <= 0) {
            throw new NoSuchElementException("queue is empty.");
        }
        return operators.poll();
    }
}
