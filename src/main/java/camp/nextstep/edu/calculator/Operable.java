package camp.nextstep.edu.calculator;

public interface Operable<T extends Number> {
    T operate(T source, T target);
}
