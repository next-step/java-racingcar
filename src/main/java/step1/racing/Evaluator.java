package step1.racing;

public interface Evaluator<T> {
    boolean evaluate(T evaluateFactor, T threshold);
    T parseValue(String value);
}
