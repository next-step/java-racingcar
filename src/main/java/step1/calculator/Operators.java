package step1.calculator;

@FunctionalInterface
public interface Operators<T> {
    T operation(T t1, T t2);
}
